package me.cherepanov.spring.config;

import me.cherepanov.spring.service.io.ConsoleInputService;
import me.cherepanov.spring.service.io.InputService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InputServiceConfig {
    @Bean
    public InputService inputService() {
        return new ConsoleInputService();
    }
}
