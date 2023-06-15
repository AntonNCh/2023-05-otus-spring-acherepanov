package me.cherepanov.spring;

import me.cherepanov.spring.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("config.properties")
@Configuration
@ComponentScan

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        TestService testService = context.getBean("testService", TestService.class);
        testService.startTest();


        context.close();
    }
}
