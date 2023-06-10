package me.cherepanov.spring.domain;

import java.util.List;

public class Question {

    private final String question;

    private final List<AnswerOption> optionsList;


    public Question(final String question, final List<AnswerOption> optionsList) {
        this.question = question;
        this.optionsList = optionsList;

    }


    public String getQuestion() {
        return question;
    }

    public List<AnswerOption> getOptions() {
        return optionsList;
    }

}
