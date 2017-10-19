package ru.clubbreakfast.at_the_lecture.patterns.Composite;

import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Manager;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    List<Product> products;
    Manager manager;

    public Orders( Manager manager) {
        this.products = new ArrayList<>();
        this.manager = manager;
    }

    double calculateOrder(){
        double sum = 0;
        for(Product product: products){
            sum = sum + product.calculateProduct();
        }
        return sum;
    }
}
