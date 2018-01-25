package com.vahundos.service.restaurant;

import com.vahundos.model.Restaurant;
import com.vahundos.to.RestaurantTo;
import com.vahundos.to.RestaurantWithMenuMealsTo;
import com.vahundos.to.RestaurantWithVoteTo;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    Restaurant create(Restaurant restaurant);

    void update(Restaurant restaurant);

    // null if not exist
    RestaurantTo get(int id);

    // null if not exist
    RestaurantWithMenuMealsTo getOneWithMenuOnDate(int id, LocalDate date);

    // null if not exist
    RestaurantWithVoteTo getOneWithVoteOnDate(int id, LocalDate date);

    // ORDERED by name asc
    List<RestaurantTo> getAll();

    // ORDERED by name asc
    List<RestaurantWithMenuMealsTo> getAllWithMenusOnDate(LocalDate date);

    // ORDERED by name asc
    List<RestaurantWithVoteTo> getAllWithVotesOnDate(LocalDate date);
}
