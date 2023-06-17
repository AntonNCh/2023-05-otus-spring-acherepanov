package me.cherepanov.spring.service.io;

import com.opencsv.CSVReader;
import me.cherepanov.spring.dao.CSVReaderQuestionsDAO;
import me.cherepanov.spring.dao.QuestionsDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Test the QuestionService with mock")
    @Test
    void questionsService() {
        QuestionsDAO questionDAO = mock(QuestionsDAO.class);
        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        questionsService.getAllQuestions();
        assertEquals(0, questionsService.getAllQuestions().size());
    }

    @DisplayName("Test the QuestionService reading from file")
    @Test
    void questionsServiceIntegr() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        QuestionsDAO questionDAO = new CSVReaderQuestionsDAO(properties.getProperty("questionary.file.name"));
        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        questionsService.getAllQuestions();
        assertEquals(3, questionsService.getAllQuestions().size());
    }
}
