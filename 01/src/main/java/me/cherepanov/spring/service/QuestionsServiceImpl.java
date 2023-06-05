package me.cherepanov.spring.service;

import me.cherepanov.spring.dao.QuestionsPool;
import me.cherepanov.spring.domain.Question;

public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsPool questionsPool;

    public QuestionsServiceImpl(QuestionsPool dao) {
        this.questionsPool = dao;
    }


    @Override
    public int getSize() {
        return questionsPool.getAll().size();
    }

    @Override
    public Question getByNumber(int index) {
        return questionsPool.getAll().get(index);
    }
}
