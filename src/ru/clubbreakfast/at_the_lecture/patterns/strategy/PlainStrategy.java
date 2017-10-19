package ru.clubbreakfast.at_the_lecture.patterns.strategy;

public class PlainStrategy implements MovingStrategy{
    @Override
    public void move() {
        System.out.println("I fly!!!");
    }
}
