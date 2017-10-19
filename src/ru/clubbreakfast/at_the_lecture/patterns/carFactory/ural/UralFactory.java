package ru.clubbreakfast.at_the_lecture.patterns.carFactory.ural;


import ru.clubbreakfast.at_the_lecture.patterns.carFactory.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UralFactory implements MotoFactory {
    @Override
    public BikeMoto createBike() {
        return new UralBike();
    }

    @Override
    public SportMoto createSport() {
        return new UralSport();
    }

    @Override
    public EnduroMoto createEnduro() {
        return new UralEnduro();
    }

    @Override
    public QuatroMoto createQuatro()  {
        throw new NotImplementedException();
    }
}
