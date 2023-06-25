package me.cherepanov.spring;

import me.cherepanov.spring.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestService testService = context.getBean("testService", TestService.class);
        testService.startTest();


        context.close();
    }
}
