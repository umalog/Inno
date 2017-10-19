package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Error extends State{
    public Error(Document document) {
        super(document);
    }

    @Override
    public boolean breake() {
        return false;
    }

    @Override
    public boolean doNext() {
        return false;
    }

}
