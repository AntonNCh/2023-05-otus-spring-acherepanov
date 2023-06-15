package me.cherepanov.tests;

import me.cherepanov.spring.dao.CSVReaderQuestionsDAO;
import me.cherepanov.spring.service.io.QuestionsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Question file test")
    @Test
    void serviceTest() {
        CSVReaderQuestionsDAO questionsPoolCSVReader = new CSVReaderQuestionsDAO("questions.csv");
        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionsPoolCSVReader);
        assertEquals(5, questionsService.getAllQuestions().size());

    }
}
