package ru.kostin.currency_exchange.view.console;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.kostin.currency_exchange.exception.BadRequestException;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {
    private final RequestHandler handler;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(handler.handle(scanner.nextLine()));
        } catch (BadRequestException e) {
            System.out.println("Bad Request!");
        }
    }
}
