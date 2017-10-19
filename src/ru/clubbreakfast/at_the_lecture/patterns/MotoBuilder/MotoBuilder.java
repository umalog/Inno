package ru.clubbreakfast.at_the_lecture.patterns.MotoBuilder;

public class MotoBuilder {

    public Moto build(String modalName){
       return new Moto(MotoWiki.getPowerByName(modalName),
               MotoWiki.getCapacityByName(modalName),
               MotoWiki.getSpeedByName(modalName),
               modalName);
    }

}
