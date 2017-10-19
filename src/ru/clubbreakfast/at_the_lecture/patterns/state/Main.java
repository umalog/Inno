package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Main {

    public static void main(String[] args) {
        Document doc = new Document("заявление");
        System.out.println(doc.currentState.getClass().getSimpleName());
        if (doc.currentState.doNext())System.out.println("Новое: "+ doc.currentState.getClass().getSimpleName());
        if (doc.currentState.doNext())System.out.println("Новое: "+ doc.currentState.getClass().getSimpleName());
        if (doc.currentState.doNext())System.out.println("Новое: "+ doc.currentState.getClass().getSimpleName());
        if (doc.currentState.breake())System.out.println("Новое: "+ doc.currentState.getClass().getSimpleName());
        if (doc.currentState.breake())System.out.println("Новое: "+ doc.currentState.getClass().getSimpleName());
    }

}
