package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Commande;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class serviceCommande {
    @Autowired
    private CommandeRepository commandeRepo;

    @GetMapping(value = "/manager/commandes",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Commande> commandeList(){
        return commandeRepo.findAll();
    }

    @GetMapping(value = "/manager/commandes/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Commande Commande(@PathVariable(name = "id") Long id){
        return commandeRepo.findById(id).orElse(null);
    }

    @PutMapping(value = "/manager/update/commande/{id}")
    public Commande updateCommande(@PathVariable(name = "id") Long id, @RequestBody Commande commande){
        return commandeRepo.save(commande);
    }

    @PostMapping(value = "/admin/add/categorie")
    public Commande AddCommande(@RequestBody Commande commande){
        return commandeRepo.save(commande);
    }
}
