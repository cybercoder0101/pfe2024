package com.pfe.code.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Livreur extends Utilisateur{
    private String matricule;
    @ManyToOne
    @JoinColumn(name = "serviceLivraison_id")
    private ServiceLivraison serviceLivraison;
}
