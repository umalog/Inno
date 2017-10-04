package ru.clubbreakfast.at_the_lecture.sept25.war_and_peace;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;


public class MyProducer implements Runnable {
    private File file;

    public MyProducer(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public void run() {
        long time = new Date().getTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            while (reader.ready()) {
                Solution.que.put(reader.readLine());
            }
            MyConsumer.isStopped = true;
            long newTime = new Date().getTime();
            System.out.printf("На работу потока Producer ушло %d милисекунд\n", newTime-time);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
