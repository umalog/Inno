package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Recived extends State{
    public Recived(Document document) {
        super(document);
    }

    @Override
    public boolean doNext() {
        this.document.currentState = new Computed(this.document);
        return true;
    }

    @Override
    public boolean breake() {
        this.document.currentState = new Error(this.document);
        return true;
    }
}
