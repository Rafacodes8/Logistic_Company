package com.example.entities;

import javax.persistence.*;
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
@Table(name = "country_map")
public class CountryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "distance",
            nullable = false)
    private int distance;

    @ManyToOne
    @JoinColumn(name = "city_from_id")
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id")
    private City cityTo;

}
