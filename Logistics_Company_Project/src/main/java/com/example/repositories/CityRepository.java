package com.example.repositories;

import com.example.dto.CityDto;
import com.example.dto.CityResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.City;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
  
    @Modifying 
    @Query("SELECT new com.example.dto.CityResponse(c.name, p.uniqueNumber) FROM City c JOIN c.truckList p")
    public List<CityResponse> getJoinInformation();
}
