package me.cherepanov.spring.service.io;

import org.springframework.stereotype.Service;

@Service
public class ConsolePrinterService implements PrintService {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
