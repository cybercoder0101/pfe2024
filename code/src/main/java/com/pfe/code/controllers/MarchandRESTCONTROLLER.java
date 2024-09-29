package com.pfe.code.controllers;

import com.pfe.code.entities.Marchand;
import com.pfe.code.services.MarchandService;
import com.pfe.code.services.request.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/marchands")
public class MarchandRESTCONTROLLER {
    @Autowired
    MarchandService marchandService;


    @PostMapping("/register")
    public Marchand addMarchand(@RequestBody Register register){
        return marchandService.createMarchand(register);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<Marchand> getAll(){
        return marchandService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")

    @GetMapping("/getnc/{nom}")
    public List<Marchand>getbynomc(@PathVariable("nom")String nom){
        return marchandService.getByNomContains(nom);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/nomASC")
    public List<Marchand>ordernomA(){
        return marchandService.getByNomAsc();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/nomDESc")
    public List<Marchand>ordernomD(){
        return marchandService.getByNomDESC();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/preASC")
    public List<Marchand>orderpA(){
        return marchandService.getByPreAcs();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/preDESC")
    public List<Marchand>orderpD(){
        return marchandService.getByPreDesc();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/find/{email}")
    public Marchand getByMail(@PathVariable("email") String email){
        return marchandService.findByEmail(email).get();
    }





    @PreAuthorize("hasAnyAuthority('ADMIN','ACHETEUR')")

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        marchandService.deleteMarchandById(id);
    }
    @GetMapping("/verifyEmail/{token}")
    public Marchand verifyEmail(@PathVariable("token") String token){
        return marchandService.validateToken(token);
    }
    @PreAuthorize("hasAuthority('ACHETEUR')")
    @PutMapping("/updateinfos")
    public Marchand update(@RequestBody Marchand marchand){
        return marchandService.updateMarchand(marchand);
    }

}
