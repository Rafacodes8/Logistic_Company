package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.LogisticOrder;

@Repository
public interface LogisticOrderRepository extends CrudRepository<LogisticOrder, Integer> {
}
