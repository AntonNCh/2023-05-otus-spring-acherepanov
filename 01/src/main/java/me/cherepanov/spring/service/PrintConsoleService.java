package me.cherepanov.spring.service;

import me.cherepanov.spring.domain.Question;

import java.io.PrintStream;

public class PrintConsoleService implements PrinterService {

    private final PrintStream out;
    private final QuestionsService questionsService;

    PrintConsoleService(QuestionsService questionsService) {
        this.questionsService = questionsService;
        out = System.out;
    }

    @Override
    public void printAllQuestions() {

        int size = questionsService.getSize();
        for (int i = 0; i < size; i++) {
            Question question = questionsService.getByNumber(i);
            String questionString = question.getQuestion();
            out.println(questionString);

            String[] options = question.getOptions();
            for (String option : options) {
                out.println("  - " + option);

            }
            out.println();
        }

    }
}
