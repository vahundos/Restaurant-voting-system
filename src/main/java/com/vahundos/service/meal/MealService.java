package com.vahundos.service.meal;

import com.vahundos.model.Meal;
import com.vahundos.util.exception.NotFoundException;

import java.util.List;

public interface MealService {

    Meal create(Meal meal);

    void update(Meal meal);

    void delete(int id) throws NotFoundException;

    Meal get(int id) throws NotFoundException;

    List<Meal> getAll();
}
