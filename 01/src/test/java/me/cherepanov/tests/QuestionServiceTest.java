package me.cherepanov.tests;

import me.cherepanov.spring.domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Question Test")
public class QuestionServiceTest {

    @DisplayName("Question Init Test")
    @Test
    void ServiceTest() {

        Question question = new Question("Text", null);
        assertEquals("Text", question.getQuestion());

    }
}
