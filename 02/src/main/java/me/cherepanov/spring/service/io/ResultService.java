package me.cherepanov.spring.service.io;

import me.cherepanov.spring.domain.TestResult;
import org.springframework.stereotype.Component;

@Component
public class ResultService {
    private PrintService printService;

    ResultService(PrintService printService) {
        this.printService = printService;
    }

    public void printTestResult(TestResult testResult) {
        printService.print("");
        printService.print("%s!".formatted(testResult.getName()));
        printService.print("Finally, the result is -- %d".formatted(testResult.getScore()));
    }

}
