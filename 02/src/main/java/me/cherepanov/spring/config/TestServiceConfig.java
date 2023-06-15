package me.cherepanov.spring.config;

import me.cherepanov.spring.service.TestService;
import me.cherepanov.spring.service.TestServiceImpl;
import me.cherepanov.spring.service.io.InputService;
import me.cherepanov.spring.service.io.PrintService;
import me.cherepanov.spring.service.io.QuestionsService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestServiceConfig {
    @Bean
    public TestService testService(QuestionsService questionsService, PrintService printService,
                                   InputService inputService) {
        return new TestServiceImpl(questionsService, printService, inputService);
    }

}
