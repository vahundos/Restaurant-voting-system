package com.vahundos.to;

import java.util.Collections;
import java.util.List;

public class RestaurantWithMenuMealsTo extends RestaurantTo {

    private final List<MealWithPriceTo> meals;

    public RestaurantWithMenuMealsTo(int id, String name, List<MealWithPriceTo> meals) {
        super(id, name);
        this.meals = Collections.unmodifiableList(meals);
    }

    public List<MealWithPriceTo> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "RestaurantWithMenuMealsTo{" +
                "meals=" + meals +
                "} " + super.toString();
    }
}
