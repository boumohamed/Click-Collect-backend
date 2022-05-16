package com.pfa.clickandcollect.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    @OneToOne()
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    @JsonBackReference
    private Collection<Commande> commandes;
}
