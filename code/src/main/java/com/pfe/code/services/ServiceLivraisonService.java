package com.pfe.code.services;

import com.pfe.code.entities.ServiceLivraison;

import java.util.List;
//principe SRP
public interface ServiceLivraisonService {

    List<ServiceLivraison> getAll();
    ServiceLivraison createSl(ServiceLivraison serviceLivraison);
    ServiceLivraison UpdateSL(ServiceLivraison serviceLivraison);

    ServiceLivraison getById(Long id);

    void deleteById(Long id);
}
