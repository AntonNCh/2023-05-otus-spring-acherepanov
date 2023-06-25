package me.cherepanov.spring.service.io;

import me.cherepanov.spring.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionsService {
    List<Question> getAllQuestions();

}
