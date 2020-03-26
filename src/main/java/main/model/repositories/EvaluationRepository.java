package main.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.model.entities.Evaluation;
import main.model.entities.Promotion;

public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	List<Evaluation> findByEnseignant(int noEnseignant);	
	List<Evaluation> findByPromotion(Promotion promo);	

}