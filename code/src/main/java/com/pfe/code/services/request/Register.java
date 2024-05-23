package com.pfe.code.services.request;

import com.pfe.code.entities.Adresse;
import com.pfe.code.entities.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    private String nom;
    private String prenom;
    private String telephone;
    private String password;

    private String email;

    private Adresse adresse;

}
