package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Commande;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.ClientRepository;
import com.pfa.clickandcollect.Repositories.CommandeRepository;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class serviceCommande {
    @Autowired
    private CommandeRepository commandeRepo;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ClientRepository clientRepository;

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

    @PostMapping(value = "/user/add/commande")
    public Commande AddCommande(
            @RequestParam("products") Long[] products,
            @RequestParam("total") double total
    ){

        Commande commande = new Commande();



        commande.setClient(clientRepository.findById(2L).orElse(null));
        commande.setDate_reception(new Date());
        commande.setDate_commande(new Date());
        commande.setTotal(total);

        System.out.println(products.length);

        Collection<Produit> Items = new ArrayList<>();
        for (Long product : products) Items.add(produitRepository.findById(product).orElse(null));


        commande.setProduits(Items);

        commande.getProduits().forEach(p -> {
            System.out.println(p.getNomPrd());
        });

        return commandeRepo.save(commande);
    }
}
