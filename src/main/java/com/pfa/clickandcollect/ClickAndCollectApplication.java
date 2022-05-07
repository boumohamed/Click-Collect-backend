package com.pfa.clickandcollect;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.CategorieRepository;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import com.pfa.clickandcollect.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ClickAndCollectApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private SecurityService securityService;


    public static void main(String[] args) {
        SpringApplication.run(ClickAndCollectApplication.class, args);


    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
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






        securityService.saveNewUser("ayoub", "ayoub", "ayoub");
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
        });

    }



}



