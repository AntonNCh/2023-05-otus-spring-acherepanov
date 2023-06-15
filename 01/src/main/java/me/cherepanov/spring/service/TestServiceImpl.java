package me.cherepanov.spring.service;

import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Question;

import java.util.List;

public class TestServiceImpl implements TestService {

    private final QuestionsService questionsService;

    private final PrintService printService;

    TestServiceImpl(QuestionsService questionsService, PrintService printService) {
        this.questionsService = questionsService;
        this.printService = printService;
    }

    @Override
    public void startTest() {

        List<Question> questions = questionsService.getAllQuestions();
        for (Question question : questions) {
            publishQuestion(question);
        }
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
