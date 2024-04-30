package com.pfe.code.services.request;

import lombok.Data;

import java.util.List;

@Data

public class ProduitFilterRequest {
    private Double minPrix;
    private Double maxPrix;
    private List<String> categories;
    private List<String> souscategories;
    private Long quantiteMin;
    private Long quantiteMax;
}
