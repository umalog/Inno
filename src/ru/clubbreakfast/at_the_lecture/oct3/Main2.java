package ru.clubbreakfast.at_the_lecture.oct3;

import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) throws Exception {
        MyCustomLoader loader = new MyCustomLoader(Printer.class.getClassLoader());
        Class myClass = loader.loadClass("ru.clubbreakfast.at_the_lecture.oct3.Printer");   //!!!
        Method printMethod = myClass.getMethod("print",null);

        printMethod.invoke(myClass.newInstance(),null);


        MyCustomLoader loader2 = new MyCustomLoader();
        Class<?> c = loader2.findClass("ru.clubbreakfast.at_the_lecture.oct3.Test");   //!!!
        Object ob = c.newInstance();
        Method md = c.getMethod("show");
        md.invoke(ob);
    }
}
