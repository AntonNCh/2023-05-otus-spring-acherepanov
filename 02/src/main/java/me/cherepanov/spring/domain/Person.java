package me.cherepanov.spring.domain;

public class Person {

    private String name;

    private int testResult = 0;

    public Person(String name) {
        this.name = name;
    }

    public int getTestResult() {
        return testResult;
    }

    public void increaseScore() {
        testResult++;
    }

    public String getName() {
        return name;
    }
}
