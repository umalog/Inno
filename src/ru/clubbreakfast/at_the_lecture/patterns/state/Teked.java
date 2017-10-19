package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Teked extends State{
    public Teked(Document document) {
        super(document);
    }


    @Override
    public boolean doNext() {
        this.document.currentState = new Signed(this.document);
        return true;
    }

    @Override
    public boolean breake() {
        this.document.currentState = new Error(this.document);
        return true;
    }
}
