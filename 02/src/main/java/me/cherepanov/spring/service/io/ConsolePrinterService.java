package me.cherepanov.spring.service.io;

public class ConsolePrinterService implements PrintService {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
