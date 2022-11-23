package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
}
