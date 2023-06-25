package me.cherepanov.spring.service.io;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Question;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    @DisplayName("Test the QuestionService with mock")
    @Test
    void questionsService() throws IOException {
        QuestionsDAO questionDAO = mock(QuestionsDAO.class);
        List<Question> allQuestions = getAllQuestions();
        when(questionDAO.getAll()).thenReturn(allQuestions);

        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        assertEquals(allQuestions.size(), questionsService.getAllQuestions().size());
    }


    private List<Question> getAllQuestions() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        String fileName = properties.getProperty("questionary.file.name");
        try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader filereader = new InputStreamReader(stream);
             CSVReader csvReader = new CSVReader(filereader)) {
            return readQuestions(csvReader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Question> readQuestions(CSVReader csvReader) throws IOException, CsvValidationException {
        List<Question> questions = new ArrayList<>();
        String[] questionRecord;
        while ((questionRecord = csvReader.readNext()) != null) {
            if (questionRecord.length > 3) {
                String questionText = questionRecord[0];
                String ritghtAnswer = questionRecord[questionRecord.length - 1];
                String[] answers = ArrayUtils.subarray(questionRecord, 1,
                        questionRecord.length - 1);
                List<AnswerOption> options = new ArrayList<>();
                for (int i = 0; i < answers.length; i++) {
                    options.add(new AnswerOption(answers[i], answers[i].startsWith(ritghtAnswer)));
                }

                Question question = new Question(questionText, options);
                questions.add(question);
            } else {
                throw new IllegalStateException("Illegal line formats. Skipped...");
            }
        }
        return questions;
    }

}
