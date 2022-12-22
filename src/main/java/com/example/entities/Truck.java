package com.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "unique_number",
            nullable = false,
            length = 7)
    private String uniqueNumber;
    @Column(name = "capacity_tons",
            nullable = false)
    private int capacityTons;
    @Column(name = "t_status",
            nullable = false)
    private boolean tStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private City city;
    
    @ManyToMany(mappedBy = "trucks")
    List<Driver> drivers;

    @OneToMany(mappedBy = "truck", cascade = CascadeType.ALL)
    private List<LogisticOrder> orderList;


}
