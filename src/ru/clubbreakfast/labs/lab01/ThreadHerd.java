package ru.clubbreakfast.labs.lab01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;


class ThreadHerd {

    private static volatile boolean isStopped = false;

    static boolean isStopped() {
        return isStopped;
    }

    static void setIsStopped() {
        isStopped = true;
    }

    ThreadPoolExecutor executor;


    ThreadHerd(List<File> files) {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(files.size());

        /* it was possible to cycle, but I tried parallelStream)*/
        files.parallelStream().forEach(file -> {
            Future<?> fut = executor.submit(() -> {

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    Parser parser = new Parser();
                    while (reader.ready() & !isStopped()) {
                        try {
                            parser.parseLine(reader.readLine());
                        } catch (Parser.FileParseException e) {
                            System.out.printf("\nНедопустимый кот в файле: %s,\n строка: %s.\nПроцесс записи остановлен в момент обнаружения кота.\n\n", file.getName(), e.getMessage());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        });
    }

}
