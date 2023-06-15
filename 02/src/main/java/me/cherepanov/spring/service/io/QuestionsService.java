package me.cherepanov.spring.service.io;

import me.cherepanov.spring.domain.Question;

import java.util.List;

public interface QuestionsService {
    List<Question> getAllQuestions();

}
