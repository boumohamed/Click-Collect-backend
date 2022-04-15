package com.pfa.clickandcollect.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String Designation;

    @OneToMany(mappedBy = "cat", fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection<Produit> produits;
}
