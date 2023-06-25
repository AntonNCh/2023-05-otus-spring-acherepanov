package me.cherepanov.spring.domain;

public class AnswerOption {

    private final String optionText;

    private final boolean isCorrect;

    public AnswerOption(String Text, boolean isCorrect) {
        this.optionText = Text;
        this.isCorrect = isCorrect;
    }

    public String getOptionText() {
        return optionText;
    }

    public Boolean isCorrect() {
        return isCorrect;
    }
}
