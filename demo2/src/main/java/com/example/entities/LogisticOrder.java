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
@Table(name = "logistic_order")
public class LogisticOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "completed",
            nullable = false)
    private boolean completed;

    @Column(name = "order_name",
            nullable = false)
    private String orderName;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "city_from_id")
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id")
    private City cityTo;

    @ManyToMany
    @JoinTable(
            name = "cargo_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cargo_id")
    )
    Set<Cargo> cargos;

}
