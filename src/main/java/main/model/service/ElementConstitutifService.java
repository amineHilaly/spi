package main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.ElementConstitutifBusiness;
import main.model.entities.ElementConstitutif;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/elementConstitutif")
public class ElementConstitutifService {

	
	@Autowired
	ElementConstitutifBusiness ecBusiness;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{codeFormation}/{codeUe}", produces = "application/json")
	public List<ElementConstitutif> recupererUeParFormation(@PathVariable String codeFormation, @PathVariable String codeUe) {
		return ecBusiness.getElementConstitutifByUE(codeUe, codeFormation);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, produces = "application/json")
	public List<ElementConstitutif> recupererUeParFormationEns(@PathVariable String codeFormation, @PathVariable String codeUe, @PathVariable int noEnseignant) {
		return ecBusiness.getAllElementConstitutif();
		
	}
}
