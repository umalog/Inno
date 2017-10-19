package ru.clubbreakfast.at_the_lecture.patterns.MotoBuilder;

public class Moto {
    private int power;
    private int engineCapacity;
    private int maxSpeed;
    private String modelName;

    public Moto(int power, int engineCapacity, int maxSpeed, String modelName) {
        this.power = power;
        this.engineCapacity = engineCapacity;
        this.maxSpeed = maxSpeed;
        this.modelName = modelName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
