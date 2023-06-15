package me.cherepanov.tests;

import me.cherepanov.spring.dao.CSVReaderQuestionDAO;
import me.cherepanov.spring.service.QuestionsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Question file test")
    @Test
    void serviceTest() {
        CSVReaderQuestionDAO questionsPoolCSVReader = new CSVReaderQuestionDAO("questions.csv");
        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionsPoolCSVReader);
        assertEquals(5, questionsService.getAllQuestions().size());

    }
}
