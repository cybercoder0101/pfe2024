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
    List<Produit> getAll(){
        return produitService.getAll();
    }
    @PostMapping("/addprod")
    Produit addProd(Produit produit){
        return produitService.saveProduit(produit);
    }
}
