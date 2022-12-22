/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controler;

import com.example.entities.Driver;
import com.example.entities.LogisticOrder;
import com.example.entities.Truck;
import com.example.repositories.CityRepository;
import com.example.repositories.DriverRepository;
import com.example.repositories.LogisticOrderRepository;
import com.example.repositories.TruckRepository;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Controller
public class DriverController {
    
   
    
    @Autowired
    private CityRepository repoCity;
    
    @Autowired
    private TruckRepository repoTruck;
    
    @Autowired
    private DriverRepository repoDriver;
    
    @Autowired LogisticOrderRepository repoOrder;
    
    
    @GetMapping("/LogisticsCompany/employee/edittruck/adddriver")
    public String addDriver(Driver driver, Model model) {
        model.addAttribute("cities", repoCity.findAll());
        model.addAttribute("trucks", repoTruck.findAll());
        ArrayList<String> driverStatusArray = new ArrayList<>();
        driverStatusArray.add("Behind wheel");
        driverStatusArray.add("Second Driver");
        driverStatusArray.add("Rest");
        driverStatusArray.add("Loading/Unloading");
        model.addAttribute("driverStatusArray", driverStatusArray);
        return "LC_addDriver";
    }
    
    @PostMapping("/LogisticsCompany/employee/edittruck/adddriver/add")
    public String processFormDriver(Driver driver) {
         repoDriver.save(driver);
        return  "redirect:/LogisticsCompany/employee/edittruck/";
    }
    
    @GetMapping(value = "/LogisticsCompany/employee/edittruck/editdriver/{id}")
    public String editDriver(@PathVariable("id") Integer id, Model model){
        ArrayList<String> driverStatusArray = new ArrayList<>();
        driverStatusArray.add("Behind wheel");
        driverStatusArray.add("Second Driver");
        driverStatusArray.add("Rest");
        driverStatusArray.add("Loading/Unloading");
        model.addAttribute("driverStatusArray", driverStatusArray);
        model.addAttribute("cities", repoCity.findAll());
        model.addAttribute("trucks", repoTruck.findAll());
        model.addAttribute("driver", repoDriver.findById(id).get());
        return "LC_editDriver";
    }
    
    @PostMapping("/LogisticsCompany/employee/edittruck/editdriver/{id}")
    public String processEditDriver(@PathVariable("id") Integer id, Driver driverChanges) {
        Driver updateDriver = repoDriver.findById(id).get(); 
        updateDriver.setCity(driverChanges.getCity());
        updateDriver.setDriverName(driverChanges.getDriverName());
        updateDriver.setDriverStatus(driverChanges.getDriverStatus());
        updateDriver.setOrderList(driverChanges.getOrderList());
        updateDriver.setPersonalNumber(driverChanges.getPersonalNumber());
        updateDriver.setSurname(driverChanges.getSurname());
        updateDriver.setTrucks(driverChanges.getTrucks());
        updateDriver.setWorkingHoursMonth(driverChanges.getWorkingHoursMonth());
        repoDriver.save(updateDriver);
        return  "redirect:/LogisticsCompany/employee/edittruck/";
    }

    @GetMapping(value = "/LogisticsCompany/employee/edittruck/deletedriver/{id}")
    public String deleteDriver(@PathVariable("id") Integer id){
        repoDriver.deleteById(id);
        return "redirect:/LogisticsCompany/employee/edittruck/";
    }
}
