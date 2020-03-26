package main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.UniteEnseignementBusiness;
import main.model.entities.UniteEnseignement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/uniteEnseignement")
public class UniteEnseignementService {

	
	@Autowired
	UniteEnseignementBusiness ueBusiness;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/ens/{noEnseignant}", produces = "application/json")
	public List<UniteEnseignement> recupererUEParEnseignant(@PathVariable int noEnseignant) {
		return ueBusiness.rechercherParEnseignant(noEnseignant);
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/{codeFormation}", produces = "application/json")
	public List<UniteEnseignement> recupererUeParFormation(@PathVariable String codeFormation) {
		System.out.println(codeFormation);
		return ueBusiness.rechercherParFormation(codeFormation);		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/ensfor/{noEnseignant}/{codeFormation}", produces = "application/json")
	public List<UniteEnseignement> recupererUeParEnsFormation(@PathVariable int noEnseignant,@PathVariable String codeFormation) {
		return ueBusiness.rechercherParFormationEnseignant(codeFormation,noEnseignant);
		
	}
}
