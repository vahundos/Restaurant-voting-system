package com.vahundos;

import com.vahundos.model.Restaurant;
import com.vahundos.to.MealWithPriceTo;
import com.vahundos.to.RestaurantTo;
import com.vahundos.to.RestaurantWithVoteTo;

import java.time.LocalDate;

import static com.vahundos.MealTestData.MEAL1;
import static com.vahundos.MealTestData.MEAL2;
import static com.vahundos.MealTestData.MEAL5;
import static com.vahundos.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT_ID1 = START_SEQ + 10;
    public static final int RESTAURANT_ID2 = START_SEQ + 11;
    public static final int RESTAURANT_ID3 = START_SEQ + 12;

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT_ID1, "Морской");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT_ID2, "Китайский");
    public static final Restaurant RESTAURANT3 = new Restaurant(RESTAURANT_ID3, "Французкий");

    public static final RestaurantTo RESTAURANT1_TO = new RestaurantTo(RESTAURANT_ID1, "Морской");
    public static final RestaurantTo RESTAURANT2_TO = new RestaurantTo(RESTAURANT_ID2, "Китайский");
    public static final RestaurantTo RESTAURANT3_TO = new RestaurantTo(RESTAURANT_ID3, "Французкий");

    public static final LocalDate DATE = LocalDate.of(2018, 1, 1);

    public static final MealWithPriceTo RESTAURANT1_MEAL1 = new MealWithPriceTo(MEAL2.getId(), MEAL2.getName(), 150);
    public static final MealWithPriceTo RESTAURANT1_MEAL2 = new MealWithPriceTo(MEAL1.getId(), MEAL1.getName(), 100);

    public static final MealWithPriceTo RESTAURANT2_MEAL1 = new MealWithPriceTo(MEAL5.getId(), MEAL5.getName(), 125);
    public static final MealWithPriceTo RESTAURANT2_MEAL2 = new MealWithPriceTo(MEAL1.getId(), MEAL1.getName(), 250);

    public static final RestaurantWithVoteTo RESTAURANT1_VOTE =
            new RestaurantWithVoteTo(RESTAURANT_ID1, RESTAURANT1.getName(), 1);

    public static final RestaurantWithVoteTo RESTAURANT2_VOTE =
            new RestaurantWithVoteTo(RESTAURANT_ID2, RESTAURANT2.getName(), 2);

    public static final RestaurantWithVoteTo RESTAURANT3_VOTE =
            new RestaurantWithVoteTo(RESTAURANT_ID3, RESTAURANT3.getName(), 0);
}
