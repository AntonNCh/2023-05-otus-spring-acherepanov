package me.cherepanov.spring.config;

import me.cherepanov.spring.dao.CSVReaderQuestionsDAO;
import me.cherepanov.spring.dao.QuestionsDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QuestionsDAOConfig {
    @Bean
    public QuestionsDAO questionsDao(@Value("${questionary.file.name}") String filename) {
        return new CSVReaderQuestionsDAO(filename);
    }
}
