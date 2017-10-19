package ru.clubbreakfast.at_the_lecture.patterns.state;

public abstract class State {
    public Document document;

    public State(Document document) {
        this.document = document;
    }

    public abstract boolean doNext();

    public abstract boolean breake();


}
