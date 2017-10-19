package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Computed extends State{
    public Computed(Document document) {
        super(document);
    }

    @Override
    public boolean doNext() {
        return false;
    }


    @Override
    public boolean breake() {
        this.document.currentState = new Error(this.document);
        return true;
    }
}
