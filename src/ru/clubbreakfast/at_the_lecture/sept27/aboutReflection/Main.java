package ru.clubbreakfast.at_the_lecture.sept27.aboutReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {
        printParent();
        System.out.println("----------------------");
        printChild(new Child());
        System.out.println("----------------------");
        Child ch = new Child();
        modifyPrivate(ch);
        System.out.println("----------------------");
        printPrivate(ch);
        System.out.println("----------------------");
        invokePrivate(new Child());

    }

    public static void printParent(){
        for(Field f: Parent.class.getDeclaredFields()){
            System.out.println(f.getName()+ " "+ f.getType().getName()+ " "+ f.getModifiers());
        }
        for(Method m: Parent.class.getDeclaredMethods()){
            System.out.println(m.getName()+ " "+ m.getReturnType().getName()+ " ");
            for(Parameter p:m.getParameters()){
                System.out.println("\t"+p.getName()+" "+p.getType().getName());
            }
        }
    }

    public static void printChild(Child child) {
        for (Field f : child.getClass().getFields()) {
            System.out.println(f.getName() + " " + f.getType().getName() + " " + f.getModifiers());
        }
        for (Method m : child.getClass().getMethods()) {
            System.out.println(m.getName() + " " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("\t" + p.getName() + " " + p.getType().getName());
            }
        }
    }

    public static void modifyPrivate(Child child) {
        Field field = null;
        try {
            field = child.getClass().getDeclaredField("privateLong");
            field.setAccessible(true);
            field.set(child, 100L);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void printPrivate(Child child) {
        Field field = null;
        try {
            field = child.getClass().getDeclaredField("privateLong");
            field.setAccessible(true);
            System.out.println(field.get(child));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void invokePrivate(Child child){
        try {
            Method method = child.getClass().getDeclaredMethod("privateProcedure", int.class);
            method.setAccessible(true);
            method.invoke(child, 5);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
