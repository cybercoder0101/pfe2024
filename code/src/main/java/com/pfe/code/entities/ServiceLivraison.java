package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class ServiceLivraison extends Utilisateur{

    private String description;

    @JsonIgnore

    @OneToMany(mappedBy = "serviceLivraison", fetch = FetchType.EAGER)

    private List<Livreur> livreurs;
    @JsonIgnore
    @OneToMany(mappedBy = "serviceLivraison")
    private List<Commande>commandes;
}
