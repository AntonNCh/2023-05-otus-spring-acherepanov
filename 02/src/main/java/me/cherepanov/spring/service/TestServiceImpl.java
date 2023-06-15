package me.cherepanov.spring.service;

import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Person;
import me.cherepanov.spring.domain.Question;
import me.cherepanov.spring.service.io.InputService;
import me.cherepanov.spring.service.io.PrintService;
import me.cherepanov.spring.service.io.QuestionsService;

import java.util.List;

public class TestServiceImpl implements TestService {

    private final QuestionsService questionsService;

    private final PrintService printService;

    private final InputService inputService;

    private Person person;

    public TestServiceImpl(QuestionsService questionsService, PrintService printService, InputService inputService) {
        this.questionsService = questionsService;
        this.printService = printService;
        this.inputService = inputService;
    }

    @Override
    public void startTest() {
        authantication();
        processTheTest();
        printTestResult(person);
    }

    private void processTheTest() {
        List<Question> questions = questionsService.getAllQuestions();
        questions.forEach(question -> {
            publishQuestion(question);
            String answer = inputUsersAnswer();
            if (checkAnswer(answer, question.getOptions())) {
                person.increaseScore();
            }
        });
    }

    private void authantication() {
        printService.print("Please introduce yourself:");
        String personName = inputService.read();
        person = new Person(personName);
    }

    private void printTestResult(Person person) {
        printService.print("");
        printService.print("%s!".formatted(person.getName()));
        printService.print("Finally, the result is -- %d".formatted(person.getTestResult()));
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
