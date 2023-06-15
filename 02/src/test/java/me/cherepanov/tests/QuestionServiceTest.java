package me.cherepanov.tests;

import me.cherepanov.spring.dao.CSVReaderQuestionsDAO;
import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.service.io.QuestionsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Test question Service with mock")
    @Test
    void serviceTest() {

        QuestionsDAO questionDAO = mock(QuestionsDAO.class);

        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        questionsService.getAllQuestions();

        assertEquals(0, questionsService.getAllQuestions().size());

    }
}
