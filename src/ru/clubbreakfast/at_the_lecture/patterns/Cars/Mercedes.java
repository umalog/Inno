package ru.clubbreakfast.at_the_lecture.patterns.Cars;

public class Mercedes extends AbstractCar {
    @Override
    public void Crash(Object context) {
        System.out.println("Продавай почку!");
    }

    protected Mercedes(){

    }

}
