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

import main.model.business.EtudiantBusiness;
import main.model.entities.Etudiant;
import main.model.entities.Promotion;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
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
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	 public void creerEtudiant(@RequestBody Etudiant etudiant) {
		System.out.println(etudiant);
		etudiantBusiness.creerEtudiant(etudiant);
	}
	
	@PutMapping()
	public void updateEtudiant(@RequestBody Etudiant etudiant) {
		etudiantBusiness.updateEtudiant(etudiant);
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
