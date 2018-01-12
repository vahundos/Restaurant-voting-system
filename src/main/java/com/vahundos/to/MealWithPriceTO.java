package com.vahundos.to;

public class MealWithPriceTO extends MealTO {
    private final int price;

    public MealWithPriceTO(int id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MealWithPriceTO{" +
                "price=" + price +
                "} " + super.toString();
    }
}
