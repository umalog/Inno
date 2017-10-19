package ru.clubbreakfast.at_the_lecture.patterns;


import ru.clubbreakfast.at_the_lecture.patterns.Cars.AbstractCar;
import ru.clubbreakfast.at_the_lecture.patterns.Cars.CarFactory;

public class Main {

    public static void main(String[] args) {

        AbstractCar[] cars = {CarFactory.createCar("Lada"),
                CarFactory.createCar("")};
        for (AbstractCar car : cars){
            car.Crash(null);
        }

    }

}
