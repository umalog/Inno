package ru.clubbreakfast.at_the_lecture.patterns.state;

public class NewState extends State{
    public NewState(Document document) {
        super(document);
    }

    @Override
    public boolean doNext() {
        this.document.currentState = new Sending(this.document);
        return true;
    }

    @Override
    public boolean breake() {
        this.document.currentState = new Error(this.document);
        return true;
    }


}
