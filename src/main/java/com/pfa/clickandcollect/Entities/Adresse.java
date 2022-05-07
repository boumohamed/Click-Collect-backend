package com.pfa.clickandcollect.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String GeoKey;
    private String CityCode;
    private String CityName;
    private String Latitude;
    private String Longitude;
    @OneToOne(mappedBy = "address")
    private Magasin magasin;
}
