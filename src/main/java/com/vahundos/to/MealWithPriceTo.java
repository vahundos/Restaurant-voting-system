package com.vahundos.to;

import java.util.Objects;

public class MealWithPriceTo extends MealTo {
    private final int price;

    public MealWithPriceTo(int id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MealWithPriceTo{" +
                "price=" + price +
                "} " + super.toString();
    }
}
