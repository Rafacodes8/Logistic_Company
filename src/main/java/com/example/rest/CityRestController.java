package com.example.rest;

import com.example.dto.CityResponse;
import com.example.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.repositories.CityRepository;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Cities")
public class CityRestController {
    
    @Autowired
    private CityRepository repo;
    
    @GetMapping
    public Iterable<City> list(){
        return repo.findAll();
    }
    @PostMapping//(produces = {MediaType.APPLICATION_JSON_VALUE })
    public void insert(@RequestBody City city){
        repo.save(city);
    }
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }
    @GetMapping("/getInfo")
    public List<CityResponse> getJoinInformation(){
        return repo.getJoinInformation();
    }
}