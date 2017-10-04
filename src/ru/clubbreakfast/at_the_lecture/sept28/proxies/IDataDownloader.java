package ru.clubbreakfast.at_the_lecture.sept28.proxies;

public interface IDataDownloader {
    void download(String url);
    String getFileContent(String url, int fileSize);
}
