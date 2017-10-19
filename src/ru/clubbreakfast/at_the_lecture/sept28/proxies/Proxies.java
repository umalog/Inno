package ru.clubbreakfast.at_the_lecture.sept28.proxies;

import java.lang.reflect.Proxy;

public class Proxies {
    public static void main(String[] args) {
        FTPDownloader ftpDownloader = new FTPDownloader();
        ftpDownloader.download("ya.ru");

        DownloaderProxy downloaderHandler = new DownloaderProxy(ftpDownloader);

        IDataDownloader proxyObject = (IDataDownloader) Proxy.newProxyInstance(FTPDownloader.class.getClassLoader(),
                FTPDownloader.class.getInterfaces(),downloaderHandler);
                // getInterfaces() == new Class<?>[]{IDataDownloader.class, IDataUploader.class}
                // Все инт-сы в массиве инт-сов должны быть прогружены тем же класслоадером

        proxyObject.download("ya.ru");
        System.out.println(proxyObject.getFileContent("google.java8",100));


    }
}
