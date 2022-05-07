package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Categorie;

import com.pfa.clickandcollect.Repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ServiceCategory {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping(value = "/user/categories",produces = MediaType.APPLICATION_JSON_VALUE)

    List<Categorie> categoryList(){
        return categorieRepository.findAll();
    }


    @GetMapping(value = "/user/categories/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Categorie oneCategory(@PathVariable(name = "id") Long id){
        return categorieRepository.findById(id).orElse(null);
    }

    

  @PostMapping(value = "/admin/add/categorie")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieRepository.save(categorie);
    }
    @PutMapping(value = "/admin/update/categories")
    public Categorie updateCategorie( @RequestBody Categorie categorie){
        return categorieRepository.save(categorie);
    }
    @DeleteMapping(value = "/admin/delete/categorie/{id}")
    public void deleteCategorie(@PathVariable(name = "id") Long id){
        categorieRepository.deleteById(id);
    }


}
