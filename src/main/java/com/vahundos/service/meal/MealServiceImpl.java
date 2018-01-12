package com.vahundos.service.meal;

import com.vahundos.model.Meal;
import com.vahundos.repository.CrudMealRepository;
import com.vahundos.util.ValidationUtil;
import com.vahundos.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.vahundos.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    private static final Sort SORT_NAME_ASC = Sort.by("name");

    @Autowired
    private CrudMealRepository repository;

    @Override
    public Meal create(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal);
    }

    @Override
    public void update(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        checkNotFoundWithId(repository.save(meal), meal.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id) != 0, id);
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    @Override
    public List<Meal> getAll() {
        return repository.findAll(SORT_NAME_ASC);
    }
}
