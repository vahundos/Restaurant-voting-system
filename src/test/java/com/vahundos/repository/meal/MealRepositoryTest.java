package com.vahundos.repository.meal;

import com.vahundos.model.Meal;
import com.vahundos.repository.AbstractRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.vahundos.MealTestData.*;
import static com.vahundos.TestUtil.assertMatch;
import static org.assertj.core.api.Assertions.assertThat;

public class MealRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private MealRepository repository;

    @Test
    public void save() {
        Meal meal = repository.save(new Meal("ааа"));
        assertMatch(meal, repository.get(meal.getId()));
        assertMatch(repository.getAll(), Arrays.asList(meal, MEAL2, MEAL6, MEAL5, MEAL4, MEAL1, MEAL3));
    }

    @Test
    public void get() {
        assertMatch(repository.get(MEAL1_ID), MEAL1);
    }

    @Test
    public void getNotExisting() {
        assertThat(repository.get(-1)).isNull();
    }

    @Test
    public void getAll() {
        assertMatch(repository.getAll(), Arrays.asList(MEAL2, MEAL6, MEAL5, MEAL4, MEAL1, MEAL3));
    }

    @Test
    public void delete() {
        assertThat(repository.delete(MEAL1_ID)).isEqualTo(true);
        assertMatch(repository.getAll(), Arrays.asList(MEAL2, MEAL6, MEAL5, MEAL4, MEAL3));
    }

    @Test
    public void deleteNotExisting() {
        assertThat(repository.delete(-1)).isEqualTo(false);
    }
}