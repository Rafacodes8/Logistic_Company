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
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "city sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )

    private int id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Truck> truckList;
    @OneToMany(mappedBy = "city")
    private List<Driver> driverList;
    @OneToMany(mappedBy = "city")
    private List<LogisticOrder> cityFromList;
    @OneToMany(mappedBy = "city")
    private List<LogisticOrder> cityToList;
    @OneToMany(mappedBy = "city")
    private List<CountryMap> mapCityFromList;
    @OneToMany(mappedBy = "city")
    private List<CountryMap> mapCityToList;

}
