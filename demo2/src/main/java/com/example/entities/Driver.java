package com.example.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
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
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "driver_name",
            nullable = false)
    private String driverName;
    @Column(name = "surname",
            nullable = false)
    private String surname;
    @Column(name = "personal_number",
            nullable = false)
    private String personalNumber;
    @Column(name = "working_hours_month",
            nullable = false)
    private int workingHoursMonth;
    @Column(name = "driver_status",
            nullable = false)
    private boolean driverStatus;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "truck_driver",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "truck_id")
    )
    Set<Truck> trucks;

    @OneToMany(mappedBy = "driver")
    private List<LogisticOrder> orderList;

}
