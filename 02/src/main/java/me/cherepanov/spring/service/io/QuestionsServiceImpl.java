package me.cherepanov.spring.service.io;

import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.domain.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsDAO questionsDAO;

    public QuestionsServiceImpl(QuestionsDAO dao) {
        this.questionsDAO = dao;
    }


    @Override
    public List<Question> getAllQuestions() {
        return questionsDAO.getAll();
    }

}
