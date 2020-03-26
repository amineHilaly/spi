package main.model.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.Qualificatif;
import main.model.entities.Rubrique;
import main.model.repositories.RubriqueEvaluationRepository;
import main.model.repositories.RubriqueRepository;

@Repository
public class RubriqueBusiness {

	@Autowired
	private RubriqueRepository rubriqueRepo;
	@Autowired
	private RubriqueEvaluationRepository rubriqueEvalRepo;
	
	
	public Rubrique creerRubrique(Rubrique rubrique) {
		rubrique.setIdRubrique(rubriqueRepo.getMaxId()+1);
		rubriqueRepo.save(rubrique);
		return rubrique;
	}
	
	public boolean updateRubrique(Rubrique rubrique) {
		if(rubriqueEvalRepo.findByIdRubrique(rubrique).isEmpty()) {
			rubriqueRepo.save(rubrique);
			return true;
		}
		else return false;
	}
	
	
	public List<Rubrique> getAllRubriques(){
		List<Rubrique> list = (List<Rubrique>) rubriqueRepo.findAll();
		return list;
		
	}
	
	
	public Optional<Rubrique> getRubriqueById(Long noRubrique) {
		return rubriqueRepo.findById(noRubrique);
	}
	
	
	public void deleteRubriqueById(Long noRubrique) {
		rubriqueRepo.deleteById(noRubrique); 
		
	}
}
