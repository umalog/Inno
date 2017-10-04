package ru.clubbreakfast.at_the_lecture.sept25;

public class BreadWare implements Runnable{
    public BreadWare() {
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Summary.produce(1,0,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
