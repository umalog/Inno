package ru.clubbreakfast.at_the_lecture.patterns.Cars;

public class Lada extends AbstractCar{
    @Override
    public void Crash(Object context) {
        System.out.println("Я приехала!!!");
    }
    protected Lada(){

    }
}
