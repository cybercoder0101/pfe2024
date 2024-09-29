package com.pfe.code;

import com.pfe.code.entities.Administrateur;
import com.pfe.code.entities.Adresse;
import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Utilisateur;
import com.pfe.code.services.*;
import com.pfe.code.services.request.Register;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BabankassouwaApplicationTests {
@Autowired
	MarchandService marchandService;
@Autowired
FournisseurService fournisseurService;

@Autowired
	LivreurService livreurService;

@Autowired
	ServiceLivraisonService livraisonService;

@Autowired
	UserService userService;
	@Test
	void contextLoads() {
		Adresse adresse= new Adresse();
		adresse.setPays("Niger");
		adresse.setVille("Niamey");
		adresse.setEmplacement("Grand Marché");
		Register m = new Register();
		m.setNom("papi");
		m.setPassword("123456");
		m.setEmail("marchand@yahoo.com");
		m.setTelephone("+22784789515");
		m.setAdresse(adresse);
		marchandService.createMarchand(m);


	}
	@Test
	void validateToken(){
		marchandService.validateToken("572260");
	}
	@Test
	void testmail(){
		Adresse adresse= new Adresse();
		adresse.setPays("Niger");
		adresse.setVille("Niamey");
		adresse.setEmplacement("Grand Marché");
		Fournisseur f= new Fournisseur();
		f.setEmail("likneo@gufum.com");
		f.setPassword("op");
		f.setNom("Houdou Inoussa");
		fournisseurService.saveFournisseur(f);
	}

	@Test
	void b(){
		Utilisateur utilisateur= userService.findByEmail("fourniseurchine@gmail.com");
		System.out.println(utilisateur.getRole().name());
	}

	@Test
	void fourn(){
		Adresse adresse= new Adresse();
		adresse.setPays("Niger");
		adresse.setVille("Niamey");
		adresse.setEmplacement("Grand Marché");
		Fournisseur fournisseur =new Fournisseur();
		fournisseur.setPassword("123");
		fournisseur.setEmail("f@gmail.com");
		fournisseur.setAdresse(adresse);
		fournisseur.setNom("Bouzou");
		fournisseur.setPrenom("Tchiwaké");
		fournisseurService.saveFournisseur(fournisseur);

	}

	@Test
	void Admin(){
		Adresse adresse= new Adresse();
		adresse.setPays("Niger");
		adresse.setVille("Niamey");
		adresse.setEmplacement("Ryad");
		Administrateur administrateur=new Administrateur();
		administrateur.setPassword("azerty");
		administrateur.setEmail("adminbbk@gmail.com");
		administrateur.setPrenom("Papi");
		administrateur.setNom("LSI 3");
		administrateur.setTelephone("+22790976142");
		fournisseurService.addadmin(administrateur);
	}



}
