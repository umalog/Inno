package ru.clubbreakfast.at_the_lecture.sept27.MonitoringStudent;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface PrintFieldForReflection {

    /* метод читает через рефлексию поля класса,
    при встече с обобщенной коллекцией (ParameterizedType),
    читает поля Типа через ту же рефлексию*/
    static void printFieldForReflection(Class cl) { //например Journal.class
        int i = 1;
        for (Field f : cl.getDeclaredFields()) { // Поле : массивВсехПолей
            System.out.println("ПОЛЕ #" + (i++));
            System.out.println(f.getName() + " " + f.getType().getSimpleName() + " " + f.getModifiers()); //Имя/Тип/номер Модификатора(isPublic/isAbstract/isFinal)
            if (f.getGenericType() instanceof ParameterizedType) { // Поле обобщенного типа?
                ParameterizedType someType = (ParameterizedType) f.getGenericType(); // Поле обобщенного типа!
                Type[] actualTypeArguments = someType.getActualTypeArguments(); //массив полей из типаОбобщения
                for (Type ata : actualTypeArguments) {
                    Class some = (Class) ata;
                    System.out.println("Обобщенный тип: " + some.getSimpleName() + ", его поля:");
                    for (Field ff : some.getDeclaredFields()) {
                        System.out.println(ff.getName() + " " + ff.getType().getName() + " " + ff.getModifiers());
                    }
                }
            }
            else{
                for (Field ff : f.getType().getDeclaredFields()) {
                    System.out.println("вложенное поле " + f.getName());
                    System.out.println(ff.getName() + " " + ff.getType().getSimpleName() + " " + ff.getModifiers());
                }
            }
            System.out.println("_________________________");
        }
    }
}
