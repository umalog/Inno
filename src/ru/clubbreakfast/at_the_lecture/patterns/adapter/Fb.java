package ru.clubbreakfast.at_the_lecture.patterns.adapter;

public class Fb extends Context {

    public void getContacts(int userId, String filter) {
        System.out.println("I show you friends of "
                + userId + " by filter " + filter);
    }

    public boolean postMessage(String message, int userId) {
        System.out.println("I post message " + message
        + " to user " + userId);
        return true;
    }
}
