
package com.example.rest;

import com.example.entities.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.repositories.TruckRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/trucks")
public class TruckRestController {
    
    @Autowired
    private TruckRepository repo;
    
    @GetMapping
    public Iterable<Truck> list(){
        return repo.findAll();
    }
    @PostMapping//(produces = {MediaType.APPLICATION_JSON_VALUE })
    public void insert(@RequestBody Truck truck){
        repo.save(truck);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }
}
