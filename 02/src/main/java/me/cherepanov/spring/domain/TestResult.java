package me.cherepanov.spring.domain;

import me.cherepanov.spring.service.io.PrintService;

public class TestResult {

    private int testResult = 0;

    private final Person person;

    private final PrintService printService;

    public TestResult(Person person, PrintService printService) {
        this.person = person;
        this.printService = printService;
    }


    public void increaseScore() {
        testResult++;
    }

    public void printTestResult() {
        printService.print("");
        printService.print("%s!".formatted(person.getName()));
        printService.print("Finally, the result is -- %d".formatted(testResult));
    }
}
