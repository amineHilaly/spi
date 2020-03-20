package main.model.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import main.model.business.RubriqueBusiness;
import main.model.entities.Rubrique;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Rubriques")
public class RubriqueWebService {
	
	@Autowired
	RubriqueBusiness RubriqueBusiness;
	
	
	@GetMapping()
	public Collection<Rubrique> getAll(){
		return RubriqueBusiness.getAllRubriques();
		
	}
	
	@GetMapping(path="/{noRubrique}", produces = "application/json")
	public Optional<Rubrique> getRubriqueById(@PathVariable Long noRubrique) {
		return RubriqueBusiness.getRubriqueById(noRubrique);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
    public Rubrique creerRubrique(@RequestBody Rubrique Rubrique) {
		return RubriqueBusiness.creerRubrique(Rubrique);
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<String> updateRubrique(@RequestBody Rubrique rubrique) {
		if (  RubriqueBusiness.updateRubrique(rubrique) == true) {
			return new ResponseEntity<String>("update OK", HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("la Rubrique est deja reference", HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/{noRubrique}")
	public @ResponseBody ResponseEntity<String> deleteRubrique(@PathVariable Long noRubrique) {
		try {
			RubriqueBusiness.deleteRubriqueById(noRubrique);
			return new ResponseEntity<String>("Rubrique a été suprimé", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("la Rubrique est deja reference", HttpStatus.OK);
		}
	    
	}
	
	
	

}
