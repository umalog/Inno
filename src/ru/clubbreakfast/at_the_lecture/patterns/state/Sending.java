package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Sending extends State{
    public Sending(Document document) {
        super(document);
    }

    @Override
    public boolean doNext() {
        this.document.currentState = new Teked(this.document);
        return true;
    }

    @Override
    public boolean breake() {
        this.document.currentState = new Error(this.document);
        return true;
    }
}
