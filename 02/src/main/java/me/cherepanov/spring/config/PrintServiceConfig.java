package me.cherepanov.spring.config;

import me.cherepanov.spring.service.io.ConsolePrinterService;
import me.cherepanov.spring.service.io.PrintService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrintServiceConfig {
    @Bean
    public PrintService printService() {
        return new ConsolePrinterService();
    }
}
