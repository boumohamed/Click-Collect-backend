package com.pfa.clickandcollect.Web;

import com.pfa.clickandcollect.Entities.Categorie;
import com.pfa.clickandcollect.Entities.Produit;
import com.pfa.clickandcollect.Repositories.CategorieRepository;
import com.pfa.clickandcollect.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ServiceProduct {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping(value = "/user/produits",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Produit> produitList(){
        return produitRepository.findAll();
    }

    @GetMapping(value = "/user/produits/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Produit produit(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/admin/add/produit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Produit addProduit(

            @RequestParam("nomPrd") String nomPrd,
            @RequestParam("prixUt") double prixUt,
            @RequestParam("image") String image,
            @RequestParam("description") String description,
            @RequestParam("categorie") Long categorie,
            @RequestParam("file") MultipartFile file

            ) throws  Exception{

        System.out.println(file.getBytes());
        Produit produit = new Produit();
        produit.setCat(categorieRepository.findById(categorie).orElse(null));
        produit.setNomPrd(nomPrd);
        produit.setPrixUt(prixUt);
        produit.setDescription(description);
        produit.setImage(image.replace(" ", ""));
        //System.out.println(produit);

        //return produitRepository.save(produit);
        return  null;
    }
    @PutMapping(value = "/admin/update/produit/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @DeleteMapping(value = "/admin/delete/produit/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }

    @GetMapping(value = "/produitimage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] produitImage(@PathVariable (name = "id") Long id) throws Exception
    {
        Produit p = produitRepository.getById(id);
        String image = p.getImage();
        File file = new File(System.getProperty("user.home") + "/pfa/images/"+image);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }













}
