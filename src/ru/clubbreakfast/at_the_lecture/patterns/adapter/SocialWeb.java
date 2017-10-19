package ru.clubbreakfast.at_the_lecture.patterns.adapter;

public interface SocialWeb {

    void getFriends(int userId);
    boolean postMessage(String message, int userId);
}
