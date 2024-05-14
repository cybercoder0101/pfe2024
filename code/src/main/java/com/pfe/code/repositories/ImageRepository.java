package com.pfe.code.repositories;

import com.pfe.code.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image>getByProduitIdProd(Long id);
}
