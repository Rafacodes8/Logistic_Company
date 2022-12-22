/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

import com.example.entities.Cargo;
import com.example.entities.LogisticOrder;
import com.example.entities.Truck;
import com.example.repositories.TruckRepository;
import java.util.ArrayList;
import java.util.Iterator;
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

    public ArrayList<Truck> obtainTrucks() {
        return (ArrayList<Truck>) truckRepository.findAll();
    }

    public ArrayList<Truck> obtainAvailableTrucks(LogisticOrder order) {
        
        ArrayList<Truck> availableTrucks = new ArrayList<>();
        
        int weight = 0;
        ArrayList<Cargo> allCargos = (ArrayList<Cargo>)order.getCargos();
        Iterator itCargo = allCargos.iterator();
        if(itCargo.hasNext()){
            Cargo thisCargo = (Cargo)itCargo.next();
            weight += thisCargo.getWeightKg();
        }
        
        ArrayList<Truck> allTrucks = (ArrayList<Truck>) truckRepository.findAll();
        Iterator itTruck = allTrucks.iterator();
        if(itTruck.hasNext()){
            Truck thisTruck = (Truck)itTruck.next();
            if(thisTruck.isTStatus() & (thisTruck.getCapacityTons() >= weight)){
                availableTrucks.add(thisTruck);
            }
        }
        
        return availableTrucks;
    }

}
