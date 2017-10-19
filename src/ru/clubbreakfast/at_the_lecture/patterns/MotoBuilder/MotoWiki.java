package ru.clubbreakfast.at_the_lecture.patterns.MotoBuilder;

public class MotoWiki {

    public static int getSpeedByName(String name){
        switch (name) {
            case "Lada": return 50;
            case "Honda": return 150;
            case "Suzuki": return 200;
            default: return 0;
        }

    }
    public static int getPowerByName(String name){
        switch (name) {
            case "Lada": return 10;
            case "Honda": return 70;
            case "Suzuki": return 150;
            default: return 0;
        }
    }
    public static int getCapacityByName(String name){
        switch (name) {
            case "Lada": return 150;
            case "Honda": return 1150;
            case "Suzuki": return 1200;
            default: return 0;
        }
    }

}
