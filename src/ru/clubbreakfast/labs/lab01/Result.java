package ru.clubbreakfast.labs.lab01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Result {

    /* Variable output mode selection */
    static volatile Boolean withoutDetails;

    private static Map<String, Integer> resultMap = new ConcurrentHashMap<>();

    static Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public static void putResultMap(String s, Integer i) {
        resultMap.put(s, i);
    }

    static synchronized void printResult() {
        System.out.println("Cлово - вхождения");
        for (Map.Entry<String, Integer> tmpEntry : getResultMap().entrySet()) {
            System.out.println(tmpEntry.getKey() + " " + tmpEntry.getValue());
        }
    }


}
