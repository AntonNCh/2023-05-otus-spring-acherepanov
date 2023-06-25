package me.cherepanov.spring.service;

import me.cherepanov.spring.dao.QuestionDAO;
import me.cherepanov.spring.domain.Question;

import java.util.List;

public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionDAO questionsPool;

    public QuestionsServiceImpl(QuestionDAO dao) {
        this.questionsPool = dao;
    }


    @Override
    public List<Question> getAllQuestions() {
        return questionsPool.getAll();
    }

}
