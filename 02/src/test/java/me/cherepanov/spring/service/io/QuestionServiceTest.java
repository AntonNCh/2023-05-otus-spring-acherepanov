package me.cherepanov.spring.service.io;

import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Question Service Test")
public class QuestionServiceTest {

    public static final String QUESTION_1 = "Question1";
    public static final String ANSWER_1 = "Answer1";

    @DisplayName("Test the QuestionService with mock")
    @Test
    void questionsService() throws IOException {
        QuestionsDAO questionDAO = mock(QuestionsDAO.class);
        List<Question> allQuestions = readQuestions();
        when(questionDAO.getAll()).thenReturn(allQuestions);

        QuestionsServiceImpl questionsService = new QuestionsServiceImpl(questionDAO);
        assertEquals(allQuestions.size(), questionsService.getAllQuestions().size());
        assertEquals(QUESTION_1, questionsService.getAllQuestions().get(0).getQuestion());
    }


    private List<Question> readQuestions() {
        List<Question> questions = new ArrayList<>();
        List<AnswerOption> options = new ArrayList<>();
        options.add(new AnswerOption(ANSWER_1, true));
        questions.add(new Question(QUESTION_1, options));

        return questions;
    }

}
