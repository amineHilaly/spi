package main.model.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.Etudiant;
import main.model.entities.Evaluation;
import main.model.entities.Promotion;
import main.model.repositories.EvaluationRepository;
import java.util.List;
@Repository
public class EvaluationBusiness {

	@Autowired
	private EvaluationRepository evaluationRepo;
	
	
	
	
	public void creerEvaluation(Evaluation evaluation) {
		evaluationRepo.save(evaluation );
	}
	
	public List<Evaluation> getAllEvaluations() {
		return (List<Evaluation>) evaluationRepo.findAll();
	}
	
	
	public Optional<Evaluation> getEvaluationById(int id) {
		return evaluationRepo.findById(id);
	}
	
	
	public List<Evaluation> findByPromotion(Promotion promo){
		
		return evaluationRepo.findByPromotion(promo);
		
	}
	
	
	
}
