package ru.clubbreakfast.at_the_lecture.patterns.carFactory;

public interface MotoFactory {

    BikeMoto createBike();

    SportMoto createSport();

    EnduroMoto createEnduro();

    QuatroMoto createQuatro();
}
