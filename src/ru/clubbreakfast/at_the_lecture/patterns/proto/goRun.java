package ru.clubbreakfast.at_the_lecture.patterns.proto;

public class goRun {
    public static void main(String[] args) {
        Destrict oldVasyki = new Destrict();
        oldVasyki.setMoney(100);
        oldVasyki.setPeople(5);

        Destrict newVasyki = (Destrict)oldVasyki.clone();
    }
}
