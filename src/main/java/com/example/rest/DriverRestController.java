
package com.example.rest;

import com.example.entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.repositories.DriverRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/drivers")
public class DriverRestController {
    
    @Autowired
    private DriverRepository repo;
    
    @GetMapping
    public Iterable<Driver> list(){
        return repo.findAll();
    }
    @PostMapping
    public void insert(@RequestBody Driver driver){
        repo.save(driver);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }
}
