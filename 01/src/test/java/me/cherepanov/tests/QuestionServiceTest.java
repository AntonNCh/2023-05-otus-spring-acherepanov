package me.cherepanov.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("QuestionService Test")
public class QuestionServiceTest {

    @DisplayName("QuestionService: Check numer of tests == 5")
    @Test
    void QuestionServiceTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        me.cherepanov.spring.service.QuestionsServiceImpl questionsService =
                context.getBean("questionsService",me.cherepanov.spring.service.QuestionsServiceImpl.class);
        assertEquals(5, questionsService.getSize());
    }
}
