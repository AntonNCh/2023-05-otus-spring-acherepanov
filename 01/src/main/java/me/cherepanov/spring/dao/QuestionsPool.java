package me.cherepanov.spring.dao;

import me.cherepanov.spring.domain.Question;

import java.util.ArrayList;

public interface QuestionsPool {

    boolean init();

    ArrayList<Question> getAll();
}
