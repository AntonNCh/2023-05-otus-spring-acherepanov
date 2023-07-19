package me.cherepanov.spring.domain;

public class TestResult {

    private int score = 0;

    private final Person person;


    public TestResult(Person person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }


    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
