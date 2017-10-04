package ru.clubbreakfast.at_the_lecture.sept28.proxies;

public class FTPDownloader implements IDataDownloader{
    @Override
    public void download(String url) {
        System.out.println("i finished from "+ url);
    }

    @Override
    public String getFileContent(String url, int fileSize) {
        return ("this is file content from: "+url);
    }
}
