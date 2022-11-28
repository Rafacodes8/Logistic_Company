package com.example.entities;

import javax.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Truck> truckList;
    @OneToMany(mappedBy = "id")
    private List<Driver> driverList;
    @OneToMany(mappedBy = "id")
    private List<LogisticOrder> cityFromList;
    @OneToMany(mappedBy = "id")
    private List<LogisticOrder> cityToList;
    @OneToMany(mappedBy = "id")
    private List<CountryMap> mapCityFromList;
    @OneToMany(mappedBy = "id")
    private List<CountryMap> mapCityToList;

}
