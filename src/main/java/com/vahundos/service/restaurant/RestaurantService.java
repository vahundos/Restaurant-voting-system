package com.vahundos.service.restaurant;

import com.vahundos.model.Restaurant;
import com.vahundos.to.RestaurantTO;
import com.vahundos.to.RestaurantWithMenuMealsTO;
import com.vahundos.to.RestaurantWithVoteTO;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    Restaurant create(Restaurant restaurant);

    void update(Restaurant restaurant);

    // null if not exist
    RestaurantTO get(int id);

    // null if not exist
    RestaurantWithMenuMealsTO getOneWithMenuOnDate(int id, LocalDate date);

    // null if not exist
    RestaurantWithVoteTO getOneWithVoteOnDate(int id, LocalDate date);

    // ORDERED by name asc
    List<RestaurantTO> getAll();

    // ORDERED by name asc
    List<RestaurantWithMenuMealsTO> getAllWithMenusOnDate(LocalDate date);

    // ORDERED by name asc
    List<RestaurantWithVoteTO> getAllWithVotesOnDate(LocalDate date);
}
