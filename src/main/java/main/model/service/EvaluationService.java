package main.model.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.EvaluationBusiness;
import main.model.entities.Enseignant;
import main.model.entities.Etudiant;
import main.model.entities.Evaluation;
import main.model.entities.Promotion;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/evaluation")
public class EvaluationService {
	
	@Autowired
	EvaluationBusiness evaluationBusiness;
	
	
	
	@RequestMapping(method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public boolean creerEvaluation(@RequestBody Evaluation evaluation) throws Exception {
		try {
			Enseignant e = new Enseignant(1); 
			evaluation.setEnseignant(e);
			if(evaluation.getElementConstitutif().getId().getCodeEc() == null) {
				evaluation.setElementConstitutif(null);
			}
			System.out.println(evaluation);
			evaluationBusiness.creerEvaluation(evaluation);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Evaluation> getAllEvaluations() {
		return evaluationBusiness.getAllEvaluations();
	}
	
	
	@RequestMapping(value="/{idEvaluation}" ,method = RequestMethod.GET, produces = "application/json")
	public Optional<Evaluation> recupererEvalParId(@PathVariable("idEvaluation") int idEvaluation) {
		return evaluationBusiness.getEvaluationById(idEvaluation);
	}
	
	
	@PostMapping(path="/promeval", consumes = "application/json", produces = "application/json")
	public List<Evaluation> getByPromotion(@RequestBody Promotion promo){
		return evaluationBusiness.findByPromotion(promo);
	}

	


}
