package ru.clubbreakfast.at_the_lecture.patterns.strategy;

public class Traveler {
    private MovingStrategy currentStrategy;
    private int sum;
    private int timeLeft;
    private boolean isApocalypsys;

    public Traveler(int sum, int timeLeft, boolean isApocalypsys) {
        this.sum = sum;
        this.timeLeft = timeLeft;
        this.isApocalypsys = isApocalypsys;
    }

    private void definedStrategy() {
        if (isApocalypsys) {
            currentStrategy = new HourseStrategy();
        } else if (timeLeft < 8) {
            currentStrategy = new PlainStrategy();
        } else if (sum < 5000) currentStrategy = new TrainStrategy();
    }

    public void startTraveling() {
        definedStrategy();
        currentStrategy.move();

    }


}
