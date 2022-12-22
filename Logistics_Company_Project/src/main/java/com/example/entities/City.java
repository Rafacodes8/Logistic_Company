package com.example.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(
            name = "city_name",
            nullable = false,
            unique = true
    )
    private String name;
    


    @OneToMany(mappedBy = "city")
    private Set<Truck> truckList;
    @OneToMany(mappedBy = "city")
    private List<Driver> driverList;
    @OneToMany(mappedBy = "cityFrom")
    private List<LogisticOrder> cityFromList;
    @OneToMany(mappedBy = "cityTo")
    private List<LogisticOrder> cityToList;
    @OneToMany(mappedBy = "id")
    private List<CountryMap> mapCityFromList;
    @OneToMany(mappedBy = "id")
    private List<CountryMap> mapCityToList;

    public City(String name) {
        this.name = name;
    }
    
    
    

}
