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
@Table(name = "truck")
public class Truck {

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

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany(mappedBy = "trucks")
    Set<Driver> drivers;

    @OneToMany(mappedBy = "id")
    private List<LogisticOrder> orderList;
}
