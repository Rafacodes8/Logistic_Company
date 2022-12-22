package com.example.controler;

import com.example.dto.CargoDto;
import com.example.dto.CityDto;
import com.example.dto.HoursDto;
import com.example.entities.Cargo;
import com.example.entities.City;
import com.example.entities.Driver;
import com.example.entities.LogisticOrder;
import com.example.entities.Truck;
import com.example.repositories.CityRepository;
import com.example.repositories.DriverRepository;
import com.example.repositories.LogisticOrderRepository;
import com.example.repositories.TruckRepository;
import com.example.repositories.CargoRepository;
import com.example.services.CargoService;
import com.example.services.CityService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Controller
@RequestMapping(path = "/LogisticsCompany")
public class LogisticsCompanyController {

    @Autowired
    private CityRepository repoCity;

    @Autowired
    private TruckRepository repoTruck;

    @Autowired
    private DriverRepository repoDriver;

    @Autowired
    private LogisticOrderRepository repoOrder;

    @Autowired
    private CargoRepository repoCargo;

    private final CityService cityService = new CityService();
    private final CargoService cargoService = new CargoService();

    @GetMapping("/buildmap")
    public String buildMap() {
        Iterator it = cityService.getIt();
        while (it.hasNext()) {
            CityDto citydto = (CityDto) it.next();
            repoCity.save(new City(citydto.getName()));
        }
        return "helloworld";
    }

    @GetMapping("/getproductlist")
    public String getProductList() {
        Iterator it = cargoService.getIt();
        while (it.hasNext()) {
            CargoDto cargodto = (CargoDto) it.next();
            repoCargo.save(new Cargo(cargodto.getUniqueNumber(), cargodto.getCargoName(), cargodto.getWeightKg(), cargodto.isCargoStatus()));
        }
        return "helloworld";
    }

    @GetMapping()
    public String entryPage() {
        return "LC_EntryPage";
    }

    @GetMapping("/employee")
    public String employeePage() {
        return "LC_EmployeeChoices";
    }

    @GetMapping("/driver")
    public String identifyDriver(Model model) {
        model.addAttribute("drivers", repoDriver.findAll());
        return "LC_IdentifyDriver";
    }

    @GetMapping("/driver/{id}")
    public String driverChoices(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "LC_DriverChoices";
    }

    @GetMapping("/driver/{id}/info")
    public String driverInformation(Model model, @PathVariable("id") Integer id) {
        ArrayList<Driver> coDrivers = new ArrayList<>();

        Driver ownDriver = repoDriver.findById(id).get();

        Iterable<Driver> drivers = repoDriver.findAll();
        drivers.forEach((p) -> {
            Driver auxDriver = p;
            System.out.println(auxDriver.getTrucks().get(0).getId());
            System.out.println(ownDriver.getTrucks().get(0).getId());
            if (auxDriver.getTrucks().get(0).getId() == ownDriver.getTrucks().get(0).getId()) {
                coDrivers.add(auxDriver);
                System.out.println(auxDriver.getDriverName());
                System.out.println(ownDriver.getDriverName());
            }
        });

        model.addAttribute("coDrivers", coDrivers);
        model.addAttribute("ownDriver", ownDriver);
        return "LC_DriverInfo";
    }

    @GetMapping("/driver/{id}/updateorder")
    public String driverUpdateOrder(Model model, @PathVariable("id") Integer id) {
        List<LogisticOrder> ownLogisticOrder = repoDriver.findById(id).get().getOrderList();
        System.out.println(repoDriver.findById(id).get().getOrderList().get(0).getCargos().get(0).getCargoName());
        model.addAttribute("orders", ownLogisticOrder);
        model.addAttribute("driverid", id);
        return "LC_DriverUpdateOrder";
    }
    
    @GetMapping("/driver/{driverid}/updatecargo/{id}")
    public String UpdateCargoStatus(Model model, @PathVariable("id") Integer id, @PathVariable("driverid") Integer driverid) {
        Cargo updateCargo = repoCargo.findById(id).get();
        updateCargo.setCargoStatus(!updateCargo.isCargoStatus());
        model.addAttribute("id", id);
        repoCargo.save(updateCargo);
        return "redirect:/LogisticsCompany/driver/" + driverid + "/updateorder";
    }
    
    @GetMapping("/driver/{id}/updateworkinghours")
    public String driverUpdateHours(Model model, @PathVariable("id") Integer id) {
        ArrayList<String> driverStatusArray = new ArrayList<>();
        driverStatusArray.add("Behind wheel");
        driverStatusArray.add("Second Driver");
        driverStatusArray.add("Rest");
        driverStatusArray.add("Loading/Unloading");
        model.addAttribute("driverStatusArray", driverStatusArray);
        HoursDto hours = new HoursDto();
        model.addAttribute("hours", hours);
        return "LC_DriverUpdateHours";
    }
    @PostMapping("/driver/{id}/updateworkinghours")
    public String processUpdateHours(@PathVariable("id") Integer id, String fromHour, String Tohour, HoursDto hours) throws ParseException{
        Driver updateDriver = repoDriver.findById(id).get(); 
        updateDriver.setDriverStatus(hours.getStatus());
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date1 = dateFormat.parse(hours.getFromHour());
        Date date2 = dateFormat.parse(hours.getToHour());
        long diffInMillies = Math.abs(date1.getTime() - date2.getTime());
        long workedHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int previouslyWorked = updateDriver.getWorkingHoursMonth();
        updateDriver.setWorkingHoursMonth(previouslyWorked + (int)workedHours);
        repoDriver.save(updateDriver);
        return "redirect:/LogisticsCompany/driver/{id}";
    }
    

    @GetMapping("/employee/edittruck")
    public String edit(Model model) {
        model.addAttribute("drivers", repoDriver.findAll());
        model.addAttribute("trucks", repoTruck.findAll());
        return "LC_EditDriverTruck";
    }

    @GetMapping("/employee/vieworder")
    public String viewOrder(Model model) {
        model.addAttribute("orders", repoOrder.findAll());
        return "LC_viewOrder";
    }
}
