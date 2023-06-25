package me.cherepanov.spring.service.io;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInputService implements InputService {


    private final Scanner sc = new Scanner(System.in);

    public ConsoleInputService() {
    }

    @Override
    public String read() {

        String str = sc.nextLine();
        return str;
    }
}
