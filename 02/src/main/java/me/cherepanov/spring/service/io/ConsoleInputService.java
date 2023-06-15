package me.cherepanov.spring.service.io;

import java.util.Scanner;

public class ConsoleInputService implements InputService {


    public ConsoleInputService() {
    }

    @Override
    public String read() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
}
