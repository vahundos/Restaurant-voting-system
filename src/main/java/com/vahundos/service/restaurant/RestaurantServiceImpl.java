package com.vahundos.service.restaurant;

import com.vahundos.model.Restaurant;
import com.vahundos.repository.CrudRestaurantRepository;
import com.vahundos.to.RestaurantTO;
import com.vahundos.to.RestaurantWithMenuMealsTO;
import com.vahundos.to.RestaurantWithVoteTO;
import com.vahundos.util.RestaurantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.vahundos.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Sort SORT_NAME_ASC = Sort.by("name");

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
        checkNotFoundWithId(repository.save(restaurant), restaurant.getId());
    }

    @Override
    public RestaurantTO get(int id) {
        return RestaurantsUtil.create(checkNotFoundWithId(repository.findById(id).orElse(null), id));
    }

    @Override
    @Transactional(readOnly = true)
    public RestaurantWithMenuMealsTO getOneWithMenuOnDate(int id, LocalDate date) {
        return RestaurantsUtil.createWithMeals(checkNotFoundWithId(repository.getOneWithMenuOnDate(id, date), id));
    }

    @Override
    public RestaurantWithVoteTO getOneWithVoteOnDate(int id, LocalDate date) {
        return RestaurantsUtil.createWithVote(checkNotFoundWithId(repository.getOneWithVoteOnDate(id, date), id));
    }

    @Override
    public List<RestaurantTO> getAll() {
        return RestaurantsUtil.create(repository.findAll(SORT_NAME_ASC));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestaurantWithMenuMealsTO> getAllWithMenusOnDate(LocalDate date) {
        return RestaurantsUtil.createWithMeals(repository.getAllWithMenusOnDate(date, SORT_NAME_ASC));
    }

    @Override
    public List<RestaurantWithVoteTO> getAllWithVotesOnDate(LocalDate date) {
        return RestaurantsUtil.createWithVote(repository.getAllWithVotesOnDate(date, SORT_NAME_ASC));
    }
}
