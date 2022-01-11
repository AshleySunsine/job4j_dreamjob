package ru.job4j.dream.store;

import ru.job4j.dream.model.City;

import java.util.Collection;

public interface StoreWithCity {

    Collection<City> findAllCity();

    City findCityById(int id);

    City findCityByName(String name);

}
