/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

import com.example.dto.CityDto;
import com.example.entities.CountryMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 *
 * @author rmoriana
 */
@Service

public class CityService {
    
    private final ArrayList<CityDto> countryMap;
    private final Iterator it;

    public CityService() {
        countryMap = new ArrayList<>();
        countryMap.add(new CityDto("Granada"));
        countryMap.add(new CityDto("Valencia"));
        countryMap.add(new CityDto("Albacete"));
        countryMap.add(new CityDto("Barcelona"));
        countryMap.add(new CityDto("Madrid"));
        countryMap.add(new CityDto("Huelva"));
        it = countryMap.iterator();
    }
    
    public ArrayList<CityDto> getCountryMap() {
        return countryMap;
    }

    public Iterator getIt() {
        return it;
    }
    
    
    
    
    
}
