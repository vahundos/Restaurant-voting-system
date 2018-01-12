package com.vahundos.to;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RestaurantWithMenuMealsTO extends RestaurantTO {

    private final List<MealWithPriceTO> meals;

    public RestaurantWithMenuMealsTO(int id, String name, List<MealWithPriceTO> meals) {
        super(id, name);
        this.meals = Collections.unmodifiableList(meals);
    }

    public List<MealWithPriceTO> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "RestaurantWithMenuMealsTO{" +
                "meals=" + meals +
                "} " + super.toString();
    }
}
