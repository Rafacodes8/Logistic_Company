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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id",
                nullable = false)
    private Truck truck;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id",
                nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "city_from_id",
                nullable = false)
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id",
                nullable = false)
    private City cityTo;

    @ManyToMany
    @JoinTable(
            name = "cargo_order",
            joinColumns = @JoinColumn(name = "order_id",
                                      nullable = false),
            inverseJoinColumns = @JoinColumn(name = "cargo_id")
    )
    List<Cargo> cargos;

}
