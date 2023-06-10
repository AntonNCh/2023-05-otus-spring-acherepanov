package me.cherepanov.spring.service;

public class ConsolePrinterService implements PrintService {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
