package ru.clubbreakfast.at_the_lecture.sept27.aboutReflection;

public class Child extends Parent{
    private Long privateLong;
    public Long publicLong;
    protected Long protectedLong;

    private void privateProcedure(int iValue){
    }
    public void publicProcedure(String sValue){

    }
    protected void protectedProcedure(int iValue, String sValue){

    }

    @Override
    public String publicFunction() {
        return super.publicFunction();
    }

    @Override
    protected String protectedFunction() {
        return super.protectedFunction();
    }

}
