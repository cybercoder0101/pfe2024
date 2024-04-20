package com.pfe.code.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    @OneToOne
    @JoinColumn(name = "marchand_id", referencedColumnName = "id")
    private Marchand marchand;
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<Produit> produits;



}
