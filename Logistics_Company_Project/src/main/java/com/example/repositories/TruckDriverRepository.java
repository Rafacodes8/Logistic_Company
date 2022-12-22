/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repositories;

import com.example.entities.LogisticOrder;
import com.example.entities.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rmoriana
 */
@Repository
public interface TruckDriverRepository extends CrudRepository<Truck, Integer> {
    
}
