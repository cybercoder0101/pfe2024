package com.pfe.code.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    private String nomProd;
    private Long prixProd;
    private String descriptionPro;
    private long quantite=400;
    @ManyToOne
    @JoinColumn(name = "fourniseur_id")
    private Fournisseur fournisseur;
}
