package com.vahundos.to;

import com.vahundos.model.Meal;

import java.util.Objects;

public class MealTO {
    private final int id;
    private final String name;

    public MealTO(Meal meal) {
        this(meal.getId(), meal.getName());
    }

    public MealTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealTO mealTO = (MealTO) o;
        return id == mealTO.id && Objects.equals(name, mealTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "MealTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
