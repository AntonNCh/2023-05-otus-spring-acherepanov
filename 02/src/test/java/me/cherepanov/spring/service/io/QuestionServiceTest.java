package me.cherepanov.spring.service.io;

import me.cherepanov.spring.dao.CSVReaderQuestionsDAO;
import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Test the QuestionService with mock")
    @Test
    void questionsService() {
        QuestionsDAO questionDAO = mock(QuestionsDAO.class);
        ArrayList<Question> objects = new ArrayList<>();
        objects.add(null);
        when(questionDAO.getAll()).thenReturn(objects);

        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        questionsService.getAllQuestions();
        assertEquals(1, questionsService.getAllQuestions().size());
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
