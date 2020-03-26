package main.model.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.*;
import main.model.entities.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Etudiant")
public class EtudiantWebService {
	
	@Autowired
	EtudiantBusiness etudiantBusiness;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/etudiants", produces = "application/json")
	public Collection<Etudiant> getAll(){
		return etudiantBusiness.getAllEtudiants();
		
	}
	
	@GetMapping(path="/{noEtudiant}", produces = "application/json")
	public Optional<Etudiant> getEtudiantById(@PathVariable String noEtudiant) {
		return etudiantBusiness.getEtudiantById(noEtudiant);
	}
	
	
	//jjjjjjjjjjjjjjjjjjjjjjj
	
	@GetMapping(path="/nom/{nom}", produces = "application/json")
	public Etudiant getEtudiantByNom(@PathVariable String nom) {
		return etudiantBusiness.findByNom(nom);
	}
	
	
	
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	 public int creerEtudiant(@RequestBody Etudiant etudiant) {
		try {
			Etudiant e = etudiantBusiness.getEtudiantById(etudiant.getNoEtudiant()).get();
			if(e != null) {
				return 1;
			}
			System.out.println(etudiant);
			etudiantBusiness.creerEtudiant(etudiant);
			return 0;
		}catch(Exception e) {
			System.out.println(e);
			return 2;
		}
	}
	
	@PutMapping()
	public boolean updateEtudiant(@RequestBody Etudiant etudiant) {
		try {
			etudiantBusiness.updateEtudiant(etudiant);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@DeleteMapping("/{noEtudiant}")
	public @ResponseBody ResponseEntity<String> deleteEtudiant(@PathVariable String noEtudiant) {
		etudiantBusiness.deleteEtudiantById(noEtudiant);
	    return new ResponseEntity<String>("Etudiant a été suprimé", HttpStatus.OK);
	}
	
	@GetMapping(path="/promotion", produces = "application/json")
	public Collection<Etudiant> getByPromotion(@PathVariable Promotion promo){
		
		return etudiantBusiness.findByPromotion(promo);
	}
	

}
