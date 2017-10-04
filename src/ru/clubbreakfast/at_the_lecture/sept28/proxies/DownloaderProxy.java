package ru.clubbreakfast.at_the_lecture.sept28.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DownloaderProxy implements InvocationHandler{
    IDataDownloader downloader;

    public DownloaderProxy(IDataDownloader downloader) {
        this.downloader = downloader;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" called at "+System.currentTimeMillis());

        if (method.getName().equals("getFileContent"))return "MyProxyContent";

        return method.invoke(downloader,args);

    }
}
