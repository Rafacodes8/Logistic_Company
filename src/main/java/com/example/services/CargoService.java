/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

import com.example.dto.CargoDto;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.stereotype.Service;



@Service
public class CargoService {
    
    private final ArrayList<CargoDto> listOfCargos;
    private final Iterator it;
   
    public CargoService(){
        listOfCargos = new ArrayList<>();
        listOfCargos.add(new CargoDto(54164, "Bycicle", 40, true));
        listOfCargos.add(new CargoDto(56347, "Car", 2000, true));
        listOfCargos.add(new CargoDto(234654, "Furniture", 80, true));
        listOfCargos.add(new CargoDto(2345, "Bricks", 7000, true));
        listOfCargos.add(new CargoDto(58356, "Apples", 400, true));
        listOfCargos.add(new CargoDto(23466, "Copper", 5000, true));
        it = listOfCargos.iterator();
    }
    
    public ArrayList<CargoDto> getListOfCargos(){
        return listOfCargos;
    }
    
    public Iterator getIt(){
        return it;
    }
}

