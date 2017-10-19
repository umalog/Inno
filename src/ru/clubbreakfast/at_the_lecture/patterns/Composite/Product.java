package ru.clubbreakfast.at_the_lecture.patterns.Composite;

import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Worker;

import java.util.ArrayList;
import java.util.List;

public class Product {
    List<Details> details;
    Worker worker;

    public Product(Worker worker) {
        this.details = new ArrayList<>();
        this.worker = worker;
    }

    double calculateProduct(){
        double sum = 0;
        for(Details det:details){
            sum = sum+det.price;
        }
        return sum;
    }
}
