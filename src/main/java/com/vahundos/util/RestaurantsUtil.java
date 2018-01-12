package com.vahundos.util;

import com.vahundos.model.Menu;
import com.vahundos.model.Restaurant;
import com.vahundos.to.MealWithPriceTO;
import com.vahundos.to.RestaurantTO;
import com.vahundos.to.RestaurantWithMenuMealsTO;
import com.vahundos.to.RestaurantWithVoteTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestaurantsUtil {

    public static RestaurantTO create(Restaurant restaurant) {
        return new RestaurantTO(restaurant.getId(), restaurant.getName());
    }

    public static List<RestaurantTO> create(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(restaurant -> new RestaurantTO(restaurant.getId(), restaurant.getName())).collect(Collectors.toList());
    }

    public static RestaurantWithMenuMealsTO createWithMeals(Restaurant restaurant) {
        List<MealWithPriceTO> mealList = restaurant.getMenus().stream()
                .flatMap(menu -> menu.getMenuMeals().stream())
                .map(menuMeal -> new MealWithPriceTO(menuMeal.getMeal().getId(), menuMeal.getMeal().getName(), menuMeal.getPrice()))
                .collect(Collectors.toList());
        return new RestaurantWithMenuMealsTO(restaurant.getId(), restaurant.getName(), mealList);
    }

    public static List<RestaurantWithMenuMealsTO> createWithMeals(List<Restaurant> restaurant) {
        return restaurant.stream().map(RestaurantsUtil::createWithMeals).collect(Collectors.toList());
    }

    public static RestaurantWithVoteTO createWithVote(Restaurant restaurant) {
        int voteCount = restaurant.getMenus().stream().map(Menu::getVotes).mapToInt(Set::size).sum();
        return new RestaurantWithVoteTO(restaurant.getId(), restaurant.getName(), voteCount);
    }

    public static List<RestaurantWithVoteTO> createWithVote(List<Restaurant> restaurants) {
        return restaurants.stream().map(RestaurantsUtil::createWithVote).collect(Collectors.toList());
    }
}
