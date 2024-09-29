package com.pfe.code.controllers;

import com.pfe.code.entities.Categorie;
import com.pfe.code.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategorieRESTController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/allcats")
    public List<Categorie> getAll(){
        return categorieService.getAll();
    }

    @GetMapping("/allnoms")
  public   List<String>getAllnoms(){
        return categorieService.getnoms();
    }

    @GetMapping("/getByid/{id}")
    public Categorie getbyid(@PathVariable("id")Long id){
        return categorieService.getCategorie(id);
    }

    @GetMapping("/nomc/{nom}")
    public List<Categorie>getnomc(@PathVariable("nom")String nom){
        return categorieService.getByNomC(nom);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addcat")
    public Categorie savecat(@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/updatecat")
   public Categorie updatecat(@RequestBody Categorie categorie){
        return categorieService.updateCategorie(categorie);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deletecat/{id}")
    public void deletecatByid(@PathVariable("id")Long id){
        categorieService.deleteCategorie(id);
    }
}
