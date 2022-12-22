/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controler;

import com.example.entities.Driver;
import com.example.entities.LogisticOrder;
import com.example.repositories.CargoRepository;
import com.example.repositories.CityRepository;
import com.example.repositories.DriverRepository;
import com.example.repositories.LogisticOrderRepository;
import com.example.repositories.TruckRepository;
import com.example.services.TruckService;
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

/**
 *
 * @author rmoriana
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Controller
public class OrderController {

    @Autowired
    private LogisticOrderRepository repoOrder;

    @Autowired
    private CityRepository repoCity;

    @Autowired
    private TruckRepository repoTruck;

    @Autowired
    private DriverRepository repoDriver;

    @Autowired
    private CargoRepository repoCargo;
    
    @Autowired
    private TruckService truckservice;

    @GetMapping("/LogisticsCompany/employee/vieworder/addorder")
    public String addOrder(LogisticOrder logisticOrder, Model model) {
        model.addAttribute("cities", repoCity.findAll());
      /////TENGO QUE CREAR OTRO MALDITO MAPOING PARA HACERLO EN 3 PASOS CARGOS-TRUCK-DRIVERXDDD/////////////////////////////////////////////////  this.truckservice.obtainAvailableTrucks(logisticOrder)
        model.addAttribute("trucks", repoTruck.findAll());
        model.addAttribute("cargos", repoCargo.findAll());
        return "LC_addOrder";
    }

    @PostMapping("/LogisticsCompany/employee/vieworder/addorder/asingDriver")
    public String assignDriver(LogisticOrder logisticOrder, Model model) {
        model.addAttribute("drivers", logisticOrder.getTruck().getDrivers());
        model.addAttribute("cities", repoCity.findAll());
        model.addAttribute("trucks", repoTruck.findAll());
        model.addAttribute("cargos", repoCargo.findAll());
        model.addAttribute("logisticOrder", logisticOrder);
        return "LC_assignDriver";
    }

    @PostMapping("/LogisticsCompany/employee/vieworder/addorder/add")
    public String processFormOrder(LogisticOrder logisticOrder) {
        repoOrder.save(logisticOrder);
        return "redirect:/LogisticsCompany/employee/vieworder";
    }

    @GetMapping("/LogisticsCompany/employee/vieworder/cargodetails/{id}")
    public String cargoDetails(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("cargos", repoOrder.findById(id).get().getCargos());
        return "LC_cargoDetails";
    }

}
