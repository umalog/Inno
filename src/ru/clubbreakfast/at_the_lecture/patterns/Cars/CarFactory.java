package ru.clubbreakfast.at_the_lecture.patterns.Cars;

public class CarFactory {
    public static AbstractCar createCar(String carName){
        switch (carName){
            case "Lada": return new Lada();
            default: return new Mercedes();
        }
    }
}
