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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    private String nomProd;
    private Double prixProd;
    private String descriptionPro;
    private long quantite=400;

    @ManyToOne
    @JoinColumn(name = "fourniseur_id")
    private Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name="panier_id")
    private Panier panier;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private SousCategorie sousCategorie;
    @ManyToOne
    private Commande commande;

}
