package com.pfe.code.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(name = "IMAGE", length = 4048576)
    @Lob
    private byte[] image;
    @ManyToOne
    @JoinColumn(name="produit_id")
    @JsonIgnore
    private Produit produit;
}
