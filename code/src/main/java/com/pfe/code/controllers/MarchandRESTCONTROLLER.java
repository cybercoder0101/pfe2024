package com.pfe.code.controllers;

import com.pfe.code.entities.Marchand;
import com.pfe.code.services.MarchandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/marchands")
public class MarchandRESTCONTROLLER {
    @Autowired
    MarchandService marchandService;

    @GetMapping("/all")
    public List<Marchand> getAll(){
        return marchandService.getAll();
    }


    @GetMapping("/getnc/{nom}")
    public List<Marchand>getbynomc(@PathVariable("nom")String nom){
        return marchandService.getByNomContains(nom);
    }

    @GetMapping("/nomASC")
    public List<Marchand>ordernomA(){
        return marchandService.getByNomAsc();
    }

    @GetMapping("/nomDESc")
    public List<Marchand>ordernomD(){
        return marchandService.getByNomDESC();
    }

    @GetMapping("/preASC")
    public List<Marchand>orderpA(){
        return marchandService.getByPreAcs();
    }
    @GetMapping("/preDESC")
    public List<Marchand>orderpD(){
        return marchandService.getByPreDesc();
    }

    @GetMapping("/find/{email}")
    public Marchand getByMail(@PathVariable("email") String email){
        return marchandService.findByEmail(email).get();
    }



    @PostMapping("/addmarchand")
    public Marchand addMarchand(@RequestBody Marchand marchand){
        return marchandService.createMarchand(marchand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        marchandService.deleteMarchandById(id);
    }


}
