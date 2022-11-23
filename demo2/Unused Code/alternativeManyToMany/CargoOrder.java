/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.;
import javax.persistence.*;
/**
 *
 * @author Rafa
 */
@Entity
@Table(name="cargo_order")
public class CargoOrder {
    
    @EmbeddedId
    private int id;
    @Column(name = "completed")
    private boolean completed;
    
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private LogisticOrder order;
    
}
