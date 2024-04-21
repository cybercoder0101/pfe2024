package com.pfe.code.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pays;
    private String ville;
    private String emplacement;
    @JsonIgnore
    @OneToMany(mappedBy = "adresse")
    private List<Utilisateur> utilisateurs;
}
