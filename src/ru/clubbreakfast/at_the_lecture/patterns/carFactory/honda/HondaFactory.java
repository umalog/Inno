package ru.clubbreakfast.at_the_lecture.patterns.carFactory.honda;


import ru.clubbreakfast.at_the_lecture.patterns.carFactory.*;

public class HondaFactory implements MotoFactory {
    @Override
    public BikeMoto createBike() {
        return new HondaBike();
    }

    @Override
    public SportMoto createSport() {
        return new HondaSport();
    }

    @Override
    public EnduroMoto createEnduro() {
        return new HondaEnduro();
    }

    @Override
    public QuatroMoto createQuatro() {
        return new HondaQuad();
    }
}
