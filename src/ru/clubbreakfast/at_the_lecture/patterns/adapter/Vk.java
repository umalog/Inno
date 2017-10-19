package ru.clubbreakfast.at_the_lecture.patterns.adapter;

public class Vk extends Context {

    public void getFriends(long userId) {
        System.out.println("I show you friends of "
                + userId);
    }

    public void post(String message, long userId, boolean notified) {
        System.out.println("I post message " + message
                + " of " + userId + " with notify "
                + notified);
    }
}
