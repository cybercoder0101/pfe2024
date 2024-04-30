package com.pfe.code.controllers;

import com.pfe.code.entities.Produit;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produits")
public class ProduitRESTController {
    @Autowired
    ProduitService produitService;

    @GetMapping("/allprods")
    public List<Produit> getAll(){
        return produitService.getAll();
    }
    @PostMapping("/addprod")
    public Produit addProd(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    @PutMapping("/update")
   public Produit update(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    @DeleteMapping("/supprimer/{id}")
    public void delete(@PathVariable("id") Long id){
        produitService.deleteById(id);
    }

    @GetMapping("/getncont/{nom}")
   public List<Produit>getBynomc(@PathVariable("nom") String nom){
        return produitService.findbynomcontains(nom);
    }

    @GetMapping("/prodcat/{idCat}")
    public List<Produit> getProduitByCatid(@PathVariable("idCat") Long idCat){
        return produitService.findbycategorieId(idCat);
    }


    @GetMapping("/prodcatnom/{nomCat}")
    public List<Produit> getProdCatn(@PathVariable("nomCat") String nomCat){
        return produitService.findByNomCat(nomCat);
    }

    @GetMapping("/prodcatacs")
    public List<Produit>getCatAcs(){
        return produitService.categorieAcs();
    }
    @GetMapping("/prix/{prix}")
    public List<Produit>getByPix(@PathVariable("prix") Double prix){
        return produitService.findprixProd(prix);
    }


}
