package com.example.demo3;

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
@Table(name = "truck2")
public class Truck2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "unique_number",
            nullable = false)
    private char[] uniqueNumber;
    @Column(name = "capacity_tons",
            nullable = false)
    private int capacityTons;
    @Column(name = "t_status",
            nullable = false)
    private boolean tStatus;

//    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;
//
//    @ManyToMany(mappedBy = "driver")
//    Set<Driver> drivers;
//
////    @OneToMany(mappedBy = "truck")
//    private List<LogisticOrder> orderList;
}
