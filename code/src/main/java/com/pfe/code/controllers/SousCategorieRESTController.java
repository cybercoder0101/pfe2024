package com.pfe.code.controllers;

import com.pfe.code.entities.SousCategorie;
import com.pfe.code.services.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/souscategories")
public class SousCategorieRESTController {
    @Autowired
    SousCategorieService sousCategorieService;

    @GetMapping("/allsc")
    public List<SousCategorie> getAll(){
        return sousCategorieService.getAll();
    }

    @GetMapping("/getssc/{id}")
    public SousCategorie getSousCat(@PathVariable("id")Long id){
        return sousCategorieService.getSousCategorie(id);
    }
    @GetMapping("/getbycatid/{id}")
    public List<SousCategorie>getByCat(@PathVariable("id")Long id){
        return sousCategorieService.getByCategorieId(id);
    }


    @GetMapping("/allnomss")
    public List<String>getAllNoms(){
        return sousCategorieService.getnomSC();
    }

    @GetMapping("/ssnomc/{nom}")
    public List<SousCategorie>getByNomC(@PathVariable("nom") String nom){
        return sousCategorieService.getByNomC(nom);
    }

    @PostMapping("/addsscat/{id}")
    public SousCategorie addSsC(@PathVariable("id") Long id,@RequestBody SousCategorie sousCategorie){
        return sousCategorieService.saveSousCategorie(id,sousCategorie);
    }

    @PutMapping("/updatecat")
    public SousCategorie updatessc(@RequestBody SousCategorie sousCategorie){
        return sousCategorieService.updateSousCategorie(sousCategorie);
    }

    @DeleteMapping("/deletessc/{id}")
    public void delete(@PathVariable("id") Long id){
        sousCategorieService.deleteSousCategorie(id);
    }

}
