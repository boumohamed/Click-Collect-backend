package com.pfa.clickandcollect.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String GeoKey;
    private String CityCode;
    private String CityName;
    private double Latitude;
    private double Longitude;
    @OneToOne(mappedBy = "adresse")
    private Magasin magasin;
}
