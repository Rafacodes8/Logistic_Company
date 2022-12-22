package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
}
