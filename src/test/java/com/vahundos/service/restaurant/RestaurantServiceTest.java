package com.vahundos.service.restaurant;

import com.vahundos.service.AbstractServiceTest;
import com.vahundos.to.RestaurantTO;
import com.vahundos.to.RestaurantWithMenuMealsTO;
import com.vahundos.to.RestaurantWithVoteTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.vahundos.RestaurantTestData.*;
import static com.vahundos.TestUtil.assertMatch;
import static com.vahundos.TestUtil.assertMatchInAnyOrder;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void testSave() {
    }

    @Test
    public void testGet() {
        assertMatch(service.get(RESTAURANT_ID1), RESTAURANT1_TO);
    }

    @Test
    public void testGetAll() {
        List<RestaurantTO> all = service.getAll();
        assertMatch(service.getAll(), Arrays.asList(RESTAURANT2_TO, RESTAURANT1_TO, RESTAURANT3_TO));
    }

    @Test
    public void testGetOneWithMenuOnDate() {
        RestaurantWithMenuMealsTO oneWithMenuOnDate = service.getOneWithMenuOnDate(RESTAURANT_ID2, DATE);
        assertMatch(oneWithMenuOnDate, RESTAURANT2_TO, "meals");
        assertMatchInAnyOrder(oneWithMenuOnDate.getMeals(), RESTAURANT2_MEAL1, RESTAURANT2_MEAL2);
    }

    @Test
    public void testGetOneWithVoteOnDate() {
        assertMatch(service.getOneWithVoteOnDate(RESTAURANT_ID2, DATE), RESTAURANT2_VOTE);
    }

    @Test
    public void testGetAllWithMenusOnDate() {
        List<RestaurantWithMenuMealsTO> allWithMenusOnDate = service.getAllWithMenusOnDate(DATE);
        RestaurantWithMenuMealsTO restaurant_id2 = allWithMenusOnDate.get(0);
        RestaurantWithMenuMealsTO restaurant_id1 = allWithMenusOnDate.get(1);
        RestaurantWithMenuMealsTO restaurant_id3 = allWithMenusOnDate.get(2);

        assertMatch(restaurant_id2, RESTAURANT2_TO, "meals");
        assertMatchInAnyOrder(restaurant_id2.getMeals(), RESTAURANT2_MEAL1, RESTAURANT2_MEAL2);

        assertMatch(restaurant_id1, RESTAURANT1_TO, "meals");
        assertMatchInAnyOrder(restaurant_id1.getMeals(), RESTAURANT1_MEAL1, RESTAURANT1_MEAL2);

        assertMatch(restaurant_id3, RESTAURANT3_TO, "meals");
        assertMatch(restaurant_id3.getMeals(), new ArrayList<>());
    }

    @Test
    public void testGetAllWithVotesOnDate() {
        List<RestaurantWithVoteTO> allWithVotesOnDate = service.getAllWithVotesOnDate(DATE);
        assertMatch(allWithVotesOnDate, Arrays.asList(RESTAURANT2_VOTE, RESTAURANT1_VOTE, RESTAURANT3_VOTE));
    }
}