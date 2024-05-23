package com.pfe.code.services.impl;

import com.pfe.code.entities.Livreur;
import com.pfe.code.entities.Role;
import com.pfe.code.entities.ServiceLivraison;
import com.pfe.code.repositories.LivreurRepository;
import com.pfe.code.repositories.ServiceLivraisonRepository;
import com.pfe.code.services.Exceptions.GlobalException;
import com.pfe.code.services.LivreurService;
import com.pfe.code.services.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreurServiceImpl implements LivreurService {
    @Autowired
    LivreurRepository livreurRepository;
    @Autowired
    ServiceLivraisonRepository serviceLivraisonRepository;
    @Autowired
    EmailSender emailSender;

    @Override
    public Livreur createLivreur(Long id, Livreur livreur) {
        ServiceLivraison serviceLivraison=serviceLivraisonRepository.findById(id).get();
        livreur.setMatricule(livreur.getNom()+serviceLivraison.getNom()+livreur.getAdresse().getPays());
        livreur.setServiceLivraison(serviceLivraison);
        livreur.setRole(Role.LIVREUR);

        return livreurRepository.save(livreur);
    }

    @Override
    public List<Livreur> getAll() {
        return livreurRepository.findAll();
    }

    @Override
    public Livreur getByid(Long id) {
        return livreurRepository.findById(id).get();
    }

    @Override
    public Livreur updateLivreur(Livreur livreur) {
        Optional<Livreur> livreurOptional= livreurRepository.findById(livreur.getId());
        if (livreurOptional.isEmpty())
            throw new GlobalException("Livreur n'est pas présent");
        livreurOptional.get().setNom(livreur.getNom());
        livreurOptional.get().setPrenom(livreur.getPrenom());
        livreurOptional.get().setTelephone(livreur.getTelephone());
        livreurOptional.get().setEmail(livreur.getEmail());
        livreurOptional.get().setAdresse(livreur.getAdresse());


        return livreurRepository.save(livreurOptional.get());
    }

    @Override
    public List<Livreur> getForServiceLivraison(Long id) {
        return livreurRepository.getLivreursByServiceLivraisonId(id);
    }

    @Override
    public void deleteLivreur(Long id) {
    livreurRepository.deleteById(id);
    }
}
