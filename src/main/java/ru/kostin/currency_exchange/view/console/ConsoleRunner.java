package ru.kostin.currency_exchange.view.console;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {
    private final RequestHandler handler;


    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService service = Executors.newSingleThreadExecutor();
        String[] command = new String[1];
        try {
            service.submit(
                    () -> command[0] = scanner.nextLine()
            ).get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException ignored) {
        } catch (TimeoutException e) {
            return;
        }
        if (command[0].equals("-1")) {
            return;
        }
        System.out.println(handler.handle(command[0]));
    }
}
