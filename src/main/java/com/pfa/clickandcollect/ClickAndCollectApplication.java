package com.pfa.clickandcollect;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.CategorieRepository;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ClickAndCollectApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;
    public static void main(String[] args) {
        SpringApplication.run(ClickAndCollectApplication.class, args);

    }

    @Override
    public void run(String... args)  {
        categorieRepository.save(new Categorie(null, "Boisson", null));
        categorieRepository.save(new Categorie(null, "Hamburger", null));
        categorieRepository.save(new Categorie(null, "Tarte", null));

        List<Categorie> cats = categorieRepository.findAll();

        categorieRepository.findAll().forEach(c -> {
            System.out.println(c.getId());
        });

        produitRepository.save(new Produit(null, "BigMag 1", 40.0, "desc 1", "image 1",
                categorieRepository.findById(1L).get()));
        produitRepository.save(new Produit(null, "BigMag 2", 50.0, "desc 2", "image 2",
                categorieRepository.findById(2L).get()));

        produitRepository.findAll().forEach(p -> {
            System.out.println(p.getCat().getDesignation());
        });





    }
}


