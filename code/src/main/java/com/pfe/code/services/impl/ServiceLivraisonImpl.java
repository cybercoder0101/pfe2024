package com.pfe.code.services.impl;

import com.pfe.code.entities.Role;
import com.pfe.code.entities.ServiceLivraison;
import com.pfe.code.repositories.ServiceLivraisonRepository;
import com.pfe.code.services.Exceptions.GlobalException;
import com.pfe.code.services.ServiceLivraisonService;
import com.pfe.code.services.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLivraisonImpl implements ServiceLivraisonService {
    @Autowired
    ServiceLivraisonRepository serviceLivraisonRepository;
    @Autowired
    EmailSender emailSender;


    @Override
    public List<ServiceLivraison> getAll() {
        return serviceLivraisonRepository.findAll();
    }

    @Override
    public ServiceLivraison createSl(ServiceLivraison serviceLivraison) {
        //envoi d'email au service de livraison
        serviceLivraison.setRole(Role.SERVICE_LIVRAISON);
        return serviceLivraisonRepository.save(serviceLivraison);
    }

    @Override
    public ServiceLivraison UpdateSL(ServiceLivraison serviceLivraison) {
        Optional<ServiceLivraison>optional= serviceLivraisonRepository.findById(serviceLivraison.getId());
        if(optional.isEmpty())
            throw new GlobalException("Le service n'existe pas");
        optional.get().setNom(serviceLivraison.getNom());
        optional.get().setPrenom(serviceLivraison.getPrenom());
        optional.get().setPassword(serviceLivraison.getPassword());
        optional.get().setAdresse(serviceLivraison.getAdresse());
        return serviceLivraisonRepository.save(serviceLivraison);
    }

    @Override
    public ServiceLivraison getById(Long id) {
        return serviceLivraisonRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
    serviceLivraisonRepository.deleteById(id);
    }
}
