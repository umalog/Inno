package ru.clubbreakfast.at_the_lecture.sept25;

import java.util.concurrent.atomic.AtomicBoolean;

public class Summary {
    private static int bread = 0;
    private static int milk = 0;
    private static int bear = 0;
    private static AtomicBoolean breadOcuped = new AtomicBoolean(false); //семафор
    private static AtomicBoolean milkOcuped = new AtomicBoolean(false);
    private static AtomicBoolean bearOcuped = new AtomicBoolean(false);

    static void produce(int bread,int milk,int bear) throws InterruptedException {
        if (bread!=0 & milk==0 & bear==0){
            if (breadOcuped.equals(true)){
                Thread.sleep(5);
                produce(bread,milk,bear);
            }else{
                breadOcuped = new AtomicBoolean(true);
                Summary.bread = Summary.bread+bread;
                breadOcuped = new AtomicBoolean(false);
            }
        }else if (bread==0 & milk!=0 & bear==0){
            if (milkOcuped.equals(true)){
                Thread.sleep(5);
                produce(bread,milk,bear);
            }else{
                milkOcuped = new AtomicBoolean(true);
                Summary.milk = Summary.milk+milk;
                milkOcuped = new AtomicBoolean(false);
            }

        }else if (bread==0 & milk==0 & bear!=0){
            if (bearOcuped.equals(true)){
                Thread.sleep(5);
                produce(bread,milk,bear);
            }else{
                bearOcuped = new AtomicBoolean(true);
                Summary.bear = Summary.bear+bear;
                bearOcuped = new AtomicBoolean(false);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for(int i=50;i>0;--i){
            new MilkWare();
            new BearWare();
            new BreadWare();
        }
        Thread.sleep(1000);
        System.out.println(bear+", "+milk+", "+bread);


    }
}
