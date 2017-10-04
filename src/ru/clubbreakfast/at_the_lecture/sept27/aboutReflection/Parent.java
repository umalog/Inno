package ru.clubbreakfast.at_the_lecture.sept27.aboutReflection;

public class Parent extends GranpParent{
    private int privateInt;
    public int publicInt;
    protected int protectedInt;

    private String prvateFunction(){
        return "private";
    }
    public String publicFunction(){
        return "public";
    }
    protected String protectedFunction(){
        return "protected";
    }


}
