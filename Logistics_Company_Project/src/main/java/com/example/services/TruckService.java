/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;
import com.example.entities.Truck;
import com.example.repositories.TruckRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author rmoriana
 */
@Service
public class TruckService {
    @Autowired
    TruckRepository truckRepository;
    
    public ArrayList<Truck> obtainTrucks(){
        return(ArrayList<Truck>) truckRepository.findAll();
    }
    
}
