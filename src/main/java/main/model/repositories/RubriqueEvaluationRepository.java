package main.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Rubrique;
import main.model.entities.RubriqueEvaluation;


@Repository
public interface RubriqueEvaluationRepository extends CrudRepository<RubriqueEvaluation, Long> {
	
	/*
	 * @Query(value =
	 * "SELECT distinct ID_RUBRIQUE_EVALUATION FROM RUBRIQUE_EVALUATION where id_evaluation = ?1 "
	 * ) public Long isReferenced(Long id);
	 */
	List<RubriqueEvaluation> findByIdRubrique(Rubrique rubrique);

	
}
