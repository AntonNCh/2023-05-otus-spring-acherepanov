package me.cherepanov.spring.service;

import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Person;
import me.cherepanov.spring.domain.Question;
import me.cherepanov.spring.domain.TestResult;
import me.cherepanov.spring.service.io.InputService;
import me.cherepanov.spring.service.io.PrintService;
import me.cherepanov.spring.service.io.QuestionsService;
import me.cherepanov.spring.service.io.ResultService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestServiceImpl implements TestService {

    private final QuestionsService questionsService;

    private final PrintService printService;

    private final InputService inputService;

    private ResultService resultService;


    public TestServiceImpl(QuestionsService questionsService, PrintService printService, InputService inputService,
                           ResultService resultService) {
        this.questionsService = questionsService;
        this.printService = printService;
        this.inputService = inputService;
        this.resultService = resultService;
    }

    @Override
    public void startTest() {
        Person person = authentication();
        TestResult testResult = processTheTest(person);
        resultService.printTestResult(testResult);
    }

    private TestResult processTheTest(Person person) {
        TestResult testResult = new TestResult(person);
        List<Question> questions = questionsService.getAllQuestions();
        questions.forEach(question -> {
            publishQuestion(question);
            String answer = inputUsersAnswer();
            if (checkAnswer(answer, question.getOptions())) {
                testResult.increaseScore();
            }
        });
        return testResult;
    }

    private Person authentication() {
        printService.print("Please introduce yourself:");
        String personName = inputService.read();
        return new Person(personName);
    }


    private boolean checkAnswer(String answer, List<AnswerOption> options) {
        if ("".equals(answer)) {
            return false;
        }
        for (AnswerOption answerOption : options) {
            if (answerOption.isCorrect() && answerOption.getOptionText().startsWith(answer)) {
                return true;
            }
        }
        return false;
    }

    private String inputUsersAnswer() {
        printService.print("");
        printService.print("Input an answer, please...");
        return inputService.read();
    }

    private void publishQuestion(Question question) {
        String questionText = question.getQuestion();
        printService.print(questionText);
        publishOptions(question);

    }

    private void publishOptions(Question question) {
        List<AnswerOption> options = question.getOptions();
        for (AnswerOption option : options) {
            printService.print("  - " + option.getOptionText());
        }
    }
}
