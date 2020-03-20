package main.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.EvaluationBusiness;
import main.model.entities.Evaluation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/evaluation")
public class EvaluationService {
	
	@Autowired
	EvaluationBusiness evaluationBusiness;
	
	
	
	@RequestMapping(method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public void creerEvaluation(@RequestBody Evaluation evaluation) throws Exception {
		 evaluationBusiness.creerEvaluation(evaluation); 
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Evaluation> getAllEvaluations() {
		return evaluationBusiness.getAllEvaluations();
	}
	
	
	@RequestMapping(value="/{idEvaluation}" ,method = RequestMethod.GET, produces = "application/json")
	public Optional<Evaluation> recupererEvalParId(@PathVariable("idEvaluation") int idEvaluation) {
		return evaluationBusiness.getEvaluationById(idEvaluation);
	}

	


}
