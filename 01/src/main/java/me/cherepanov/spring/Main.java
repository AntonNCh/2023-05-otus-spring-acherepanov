package me.cherepanov.spring;

import me.cherepanov.spring.service.PrinterService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        PrinterService printService = context.getBean("printService", PrinterService.class);
        printService.printAllQuestions();


        context.close();
    }
}
