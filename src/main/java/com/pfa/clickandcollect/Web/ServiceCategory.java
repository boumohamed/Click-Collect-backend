package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceCategory {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping(value = "/user/categories/",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Categorie> categoryList(){
        return categorieRepository.findAll();
    }

    @PostMapping(value = "/admin/add/categorie/")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieRepository.save(categorie);
    }
    @PutMapping(value = "/admin/update/categorie/{id}")
    public Categorie updateCategorie(@PathVariable(name = "id") Long id, @RequestBody Categorie categorie){
        return categorieRepository.save(categorie);
    }
    @DeleteMapping(value = "/admin/delete/categorie/{id}")
    public void deleteCategorie(@PathVariable(name = "id") Long id){
        categorieRepository.deleteById(id);
    }


}
