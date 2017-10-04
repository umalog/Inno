package ru.clubbreakfast.at_the_lecture.sept25;

public class BearWare implements Runnable{
    public BearWare() {
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
            Summary.produce(0,0,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
