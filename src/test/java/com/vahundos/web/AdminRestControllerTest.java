package com.vahundos.web;

import com.vahundos.MenuTestData;
import com.vahundos.RestaurantTestData;
import com.vahundos.TestUtil;
import com.vahundos.model.Restaurant;
import com.vahundos.service.restaurant.RestaurantService;
import com.vahundos.to.menu.MenuTo;
import com.vahundos.to.restaurant.RestaurantWithMenuMealsTo;
import com.vahundos.web.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static com.vahundos.RestaurantTestData.DATE;
import static com.vahundos.RestaurantTestData.RESTAURANT_ID3;
import static com.vahundos.TestUtil.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminRestController.REST_URL + "/";

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void testUpdate() throws Exception {
        Restaurant expected = RestaurantTestData.getForUpdating();
        mockMvc.perform(put(REST_URL + expected.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isOk())
                .andDo(print());

        assertMatch(restaurantService.get(expected.getId()), expected);
    }

    @Test
    public void testCreateWithLocation() throws Exception {
        Restaurant expected = RestaurantTestData.getForCreation();
        ResultActions resultActions = mockMvc.perform(post(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        Restaurant actual = TestUtil.readFromJson(resultActions, Restaurant.class);
        expected.setId(actual.getId());
        assertMatch(actual, expected);
    }

    @Test
    public void testCreateMenu() throws Exception {
        MenuTo expected = MenuTestData.getForCreation(DATE, RESTAURANT_ID3);
        mockMvc.perform(post(REST_URL + RESTAURANT_ID3 + "/menu").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isOk())
                .andDo(print());

        RestaurantWithMenuMealsTo restaurant = restaurantService.getOneWithMenuOnDate(RESTAURANT_ID3, DATE);
        assertMatchInAnyOrder(restaurant.getMeals(), getMealArrayFromCollection(expected.getMeals()));
    }

    @Test
    public void testUpdateMenu() throws Exception {
        MenuTo expected = MenuTestData.getForUpdating(RESTAURANT_ID3);
        mockMvc.perform(put(REST_URL + RESTAURANT_ID3 + "/menu").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isOk())
                .andDo(print());

        RestaurantWithMenuMealsTo restaurant = restaurantService.getOneWithMenuOnDate(RESTAURANT_ID3, DATE);
        assertMatchInAnyOrder(restaurant.getMeals(), getMealArrayFromCollection(expected.getMeals()));
    }
}