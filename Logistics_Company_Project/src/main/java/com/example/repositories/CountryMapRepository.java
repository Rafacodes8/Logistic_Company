package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.CountryMap;

@Repository
public interface CountryMapRepository extends CrudRepository<CountryMap, Integer> {
}
