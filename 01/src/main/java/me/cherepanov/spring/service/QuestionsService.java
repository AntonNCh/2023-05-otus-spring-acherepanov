package me.cherepanov.spring.service;

import me.cherepanov.spring.domain.Question;

public interface QuestionsService {

    int getSize();

    Question getByNumber(int index);

}
