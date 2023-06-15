package me.cherepanov.spring.service.io;

import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.domain.Question;

import java.util.List;

public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsDAO questionsPool;

    public QuestionsServiceImpl(QuestionsDAO dao) {
        this.questionsPool = dao;
    }


    @Override
    public List<Question> getAllQuestions() {
        return questionsPool.getAll();
    }

}
