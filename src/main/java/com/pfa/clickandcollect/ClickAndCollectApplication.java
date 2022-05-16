package com.pfa.clickandcollect;

import com.pfa.clickandcollect.Entities.*;
import com.pfa.clickandcollect.Repositories.AdresseRepository;
import com.pfa.clickandcollect.Repositories.CategorieRepository;
import com.pfa.clickandcollect.Repositories.ClientRepository;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import com.pfa.clickandcollect.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@SpringBootApplication
public class ClickAndCollectApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    //@Autowired
    //private SecurityService securityService;

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private ClientRepository clientRepository;


    public static void main(String[] args) {
        SpringApplication.run(ClickAndCollectApplication.class, args);


    }
    //Bean
    /*PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }*/

    @Override
    public void run(String... args)  {
        categorieRepository.save(new Categorie(null, "Boisson", null));
        categorieRepository.save(new Categorie(null, "Hamburger", null));
        categorieRepository.save(new Categorie(null, "Salade", null));

        List<Categorie> cats = categorieRepository.findAll();

        categorieRepository.findAll().forEach(c -> {
            System.out.println(c.getId());
        });


        produitRepository.save(new Produit(null, "hamburger 1", 25.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch, ", "image ",
                categorieRepository.findById(2L).orElse(null), null));
        produitRepository.save(new Produit(null, "hamburger 2", 20.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch,", "image ",
                categorieRepository.findById(2L).orElse(null), null));

        produitRepository.save(new Produit(null, "Boisson 1", 15.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch,", "image ",
                categorieRepository.findById(1L).orElse(null), null));
        produitRepository.save(new Produit(null, "Boisson 2", 17.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch, ", "image ",
                categorieRepository.findById(1L).orElse(null), null));

        produitRepository.save(new Produit(null, "Salade 1", 19.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch,", "image ",
                categorieRepository.findById(3L).orElse(null), null));
        produitRepository.save(new Produit(null, "Salade 2", 20.0, "For historic continuity, ferociously loyal community support, and an atmosphere that you could spread with a knife, you can't beat the hamburger joint Louis' Lunch,", "image ",
                categorieRepository.findById(3L).orElse(null), null));


        adresseRepository.save(new Adresse(null, "GeoKey", "CityCode", "Casablanca", 33.573109, -7.589843, null));
        clientRepository.save(new Client(null, "Hicham Oubari",
                "oubari@gmail.com", "123456789",
                adresseRepository.findById(1L).orElse(null), null));
        System.out.println(clientRepository.findById(2L).get().getAdresse().getCityName());






        /*securityService.saveNewUser("ayoub", "ayoub", "ayoub");
        securityService.saveNewUser("hicham", "hicham", "hicham");
        securityService.saveNewUser("mohamed", "mohamed", "mohamed");

        securityService.saveNewRole("USER", "utilisateur simple");
        securityService.saveNewRole("MANAGER", "utilisateur simple");
        securityService.saveNewRole("ADMIN", "Administrateur de l'application");


        securityService.addRoleToUser("ayoub", "USER");
        securityService.addRoleToUser("hicham", "USER");
        securityService.addRoleToUser("mohamed", "USER");

        securityService.addRoleToUser("hicham", "ADMIN");
        securityService.addRoleToUser("mohamed", "MANAGER");

        produitRepository.findAll().forEach(p -> {
            System.out.println(p.getNomPrd());
        });*/

    }



}



