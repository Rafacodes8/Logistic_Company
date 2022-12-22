package com.example.controler;

import com.example.entities.Driver;
import com.example.entities.Truck;
import com.example.repositories.CityRepository;
import com.example.repositories.DriverRepository;
import com.example.repositories.TruckRepository;
import com.example.repositories.TruckDriverRepository;
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

public class TruckController {

    @Autowired
    private CityRepository repoCity;

    @Autowired
    private TruckRepository repoTruck;

    @Autowired
    private DriverRepository repoDriver;

    @Autowired
    private TruckDriverRepository repoTruckDriver;

    @GetMapping("/LogisticsCompany/employee/edittruck/addtruck")
    public String addTruck(Truck truck, Model model) {
        model.addAttribute("cities", repoCity.findAll());
        model.addAttribute("drivers", repoDriver.findAll());
        return "LC_addTruck";
    }

    @PostMapping("/LogisticsCompany/employee/edittruck/addtruck")
    public String processFormTruck(Truck truck) {
        repoTruck.save(truck);
        Driver updateDriver = repoDriver.findById(truck.getDrivers().get(0).getId()).get();
        updateDriver.addTruck(truck);
        repoDriver.save(updateDriver);
        return "redirect:/LogisticsCompany/employee/edittruck/";
    }

    @GetMapping(value = "/LogisticsCompany/employee/edittruck/editruck/{id}")
    public String editTruck(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("cities", repoCity.findAll());
        model.addAttribute("truck", repoTruck.findById(id).get());
        model.addAttribute("drivers", repoDriver.findAll());
        return "LC_editTruck";
    }

    @PostMapping("/LogisticsCompany/employee/edittruck/editruck/{id}")
    public String processEditTruck(@PathVariable("id") Integer id, Truck truck) {
        Truck updateTruck = repoTruck.findById(id).get();
        updateTruck.setCapacityTons(truck.getCapacityTons());
        updateTruck.setCity(truck.getCity());
        updateTruck.setOrderList(truck.getOrderList());
        updateTruck.setTStatus(truck.isTStatus());
        updateTruck.setUniqueNumber(truck.getUniqueNumber());
        updateTruck.setCapacityTons(truck.getCapacityTons());
        repoTruck.save(updateTruck);
        
        Driver updateDriver = repoDriver.findById(truck.getDrivers().get(0).getId()).get();
        updateDriver.addTruck(updateTruck);
        repoDriver.save(updateDriver);
        return "redirect:/LogisticsCompany/employee/edittruck/";
    }

    @GetMapping(value = "/LogisticsCompany/employee/edittruck/deletetruck/{id}")
    public String deleteTruck(@PathVariable("id") Integer id) {
        repoTruck.deleteById(id);
        return "redirect:/LogisticsCompany/employee/edittruck/";
    }

}
