package ru.clubbreakfast.at_the_lecture.patterns.state;

public class Document {
    String name;
    State currentState;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Document(String name) {
        this.name = name;
        currentState = new NewState(this);
    }
}
