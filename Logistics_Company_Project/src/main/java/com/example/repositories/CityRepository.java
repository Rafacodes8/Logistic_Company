package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
}
