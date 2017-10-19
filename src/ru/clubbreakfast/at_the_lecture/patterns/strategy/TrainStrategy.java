package ru.clubbreakfast.at_the_lecture.patterns.strategy;

public class TrainStrategy implements MovingStrategy{
    @Override
    public void move() {
        System.out.println("Thooo-Thooooo!!!");
    }
}
