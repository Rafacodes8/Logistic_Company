/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo2;
import javax.persistence.*;
/**
 *
 * @author Rafa
 */
@Entity
@Table(name="truck_driver")
public class TruckDriver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
    
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    
}
