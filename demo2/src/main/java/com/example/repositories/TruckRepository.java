package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Truck;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Integer> {
}
