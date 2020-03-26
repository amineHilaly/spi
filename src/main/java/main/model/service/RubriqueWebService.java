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
	@RequestMapping(produces = "application/json; charset=utf-8")
	public Collection<Rubrique> getAll(){
		return RubriqueBusiness.getAllRubriques();
		
	}
	
	@GetMapping(path="/{noRubrique}", produces = "application/json")
	public Optional<Rubrique> getRubriqueById(@PathVariable Long noRubrique) {
		return RubriqueBusiness.getRubriqueById(noRubrique);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
    public boolean creerRubrique(@RequestBody Rubrique Rubrique) {
	    try {
	    	RubriqueBusiness.creerRubrique(Rubrique);
	    	return true;
	    }catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@PostMapping(path="/update")
	public boolean updateRubrique(@RequestBody Rubrique rubrique) {

		if (  RubriqueBusiness.updateRubrique(rubrique) == true) {
			return true;
		}
		else {
		return false;
		}
		
	}
	
	@DeleteMapping("/{noRubrique}")
	public boolean deleteRubrique(@PathVariable Long noRubrique) {
		try {
			RubriqueBusiness.deleteRubriqueById(noRubrique);
			return true;
		} catch(Exception e) {
			return false;
		}
	    
	}
	
	
	

}
