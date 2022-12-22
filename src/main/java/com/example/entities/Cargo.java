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
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "unique_number",
            nullable = false)
    private int uniqueNumber;
    @Column(name = "cargo_name",
            nullable = false)
    private String cargoName;
    @Column(name = "weight_kg",
            nullable = false)
    private int weightKg;
    @Column(name = "cargo_status",
            nullable = false)
    private boolean cargoStatus;

    @ManyToMany(mappedBy = "cargos")
    Set<LogisticOrder> orders;
    
    public Cargo(int uniqueNumber, String cargoName, int weightKg, boolean cargoStatus) {
        this.uniqueNumber = uniqueNumber;
        this.cargoName = cargoName;
        this.weightKg = weightKg;
        this.cargoStatus = cargoStatus;
    }
}
