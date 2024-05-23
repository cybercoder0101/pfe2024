package com.pfe.code.controllers;

import com.pfe.code.entities.Livreur;
import com.pfe.code.services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livreurs")
@CrossOrigin("*")
public class LivreurRESTController {
    @Autowired
    LivreurService livreurService;

    @GetMapping("/all")
    public List<Livreur> getAll(){
        return livreurService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public Livreur getById(@PathVariable("id") Long id){
        return livreurService.getByid(id);
    }
    @GetMapping("/getforsl/{id}")
    public List<Livreur>getLforSL(@PathVariable("id") Long id){
        return livreurService.getForServiceLivraison(id);
    }

    @PostMapping("/addlivreur/{idSL}")
    public Livreur add(@PathVariable("idSL")Long idSL, @RequestBody Livreur livreur){
        return livreurService.createLivreur(idSL,livreur);
    }

    @PutMapping("/updateL")
    public Livreur update(@RequestBody Livreur livreur){
        return livreurService.updateLivreur(livreur);
    }

    @DeleteMapping("/deletelivreur/{id}")
    public void delete(@PathVariable("id")Long id){
        livreurService.deleteLivreur(id);
    }


}
