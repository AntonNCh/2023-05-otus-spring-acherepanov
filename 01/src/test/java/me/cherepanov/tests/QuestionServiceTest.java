package me.cherepanov.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuestionServiceTest {
    

    @Test
    void QuestionServiceTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Object questionsService = context.getBean("questionsService");
    }
}
