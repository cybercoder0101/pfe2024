package com.pfe.code.controllers;

import com.pfe.code.entities.ServiceLivraison;
import com.pfe.code.services.ServiceLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/serviceslivraison")
public class ServiceLivraisonRESTController {

    @Autowired
    ServiceLivraisonService serviceLivraisonService;

    @GetMapping("/all")
    public List<ServiceLivraison> getAll(){
        return serviceLivraisonService.getAll();
    }


    @GetMapping("/getSl/{id}")
    public ServiceLivraison getBYId(@PathVariable ("id")Long id){
        return serviceLivraisonService.getById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")

    @PostMapping("/addSl")
    public ServiceLivraison createSl(@RequestBody ServiceLivraison serviceLivraison){
        return serviceLivraisonService.createSl(serviceLivraison);
    }


    @PreAuthorize("hasAuthority('SERVICE_LIVRAISON')")
    @PutMapping("/updateSl")
    public ServiceLivraison updateSl(@RequestBody ServiceLivraison serviceLivraison){
        return  serviceLivraisonService.UpdateSL(serviceLivraison);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','SERVICE_LIVRAISON')")
    @DeleteMapping("/deleteSL/{id}")
    public void deleteSl(@PathVariable("id") Long id){
        serviceLivraisonService.deleteById(id);
    }
}
