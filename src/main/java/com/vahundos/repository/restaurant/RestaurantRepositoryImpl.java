package com.vahundos.repository.restaurant;

import com.vahundos.model.Meal;
import com.vahundos.model.Menu;
import com.vahundos.model.MenuMeal;
import com.vahundos.model.Restaurant;
import com.vahundos.repository.meal.CrudMealRepository;
import org.hibernate.Hibernate;
import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static final Sort SORT_BY_NAME = Sort.by(Sort.Direction.ASC, "name");

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurant getOneWithMenusBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        return repository.getOneWithMenusBetweenDates(id, startDate, endDate);
    }

    @Override
    public Restaurant getOneWithVotesBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        return repository.getOneWithVotesBetweenDates(id, startDate, endDate);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll(SORT_BY_NAME);
    }

    @Override
    public List<Restaurant> getAllWithMenusBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.getAllWithMenusBetweenDates(startDate, endDate, SORT_BY_NAME);
    }

    @Override
    public List<Restaurant> getAllWithVotesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.getAllWithVotesBetweenDates(startDate, endDate, SORT_BY_NAME);
    }
}
