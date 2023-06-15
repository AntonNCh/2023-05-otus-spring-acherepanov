package me.cherepanov.spring.config;

import me.cherepanov.spring.dao.QuestionsDAO;
import me.cherepanov.spring.service.io.QuestionsService;
import me.cherepanov.spring.service.io.QuestionsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QuestionsServiceConfig {
    @Bean
    public QuestionsService questionsService(QuestionsDAO questionsDao) {
        return new QuestionsServiceImpl(questionsDao);
    }
}
