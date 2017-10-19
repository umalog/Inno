package ru.clubbreakfast.at_the_lecture.patterns.strategy;

public class Maim {
    public static void main(String[] args) {
        Traveler traveler = new Traveler(0,5,false);
        Traveler me = new Traveler(10_000,15,false);
        Traveler traveler1 = new Traveler(100_000,15,true);

        traveler.startTraveling();
        me.startTraveling();
        traveler1.startTraveling();

    }
}
