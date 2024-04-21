package com.pfe.code.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private Date dateCommande;
    @ManyToOne
    private Marchand marchand;
    @ManyToOne
    @JoinColumn(name = "service_livraison_id")
    private ServiceLivraison serviceLivraison;
    @ManyToOne
    @JoinColumn(name = "livreur_id")
    private Livreur livreur;
    @OneToMany
    @JoinTable(name = "commande_produit", joinColumns = @JoinColumn(name = "commande_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private List<Produit> produits;




}
