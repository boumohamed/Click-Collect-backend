package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
public class ServiceProduct {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/user/produits/",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Produit> produitList(){
        return produitRepository.findAll();
    }

    @PostMapping(value = "/admin/add/produit/")
    public Produit addProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @PutMapping(value = "/admin/update/produit/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @DeleteMapping(value = "/admin/delete/produit/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }



}
