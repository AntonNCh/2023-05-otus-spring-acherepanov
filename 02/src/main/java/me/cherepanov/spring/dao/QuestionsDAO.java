package me.cherepanov.spring.dao;

import me.cherepanov.spring.domain.Question;

import java.util.List;

public interface QuestionsDAO {


    List<Question> getAll();
}
