package ru.clubbreakfast.at_the_lecture.sept25.war_and_peace;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Solution {
    static BlockingQueue<String> que = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        Thread prod = new Thread(new MyProducer(args[0]));
        prod.start();
        Thread cons = new Thread(new MyConsumer());
        cons.start();

        prod.join();
        cons.join();
    }
}
