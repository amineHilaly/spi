package main.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Question;
import main.model.entities.QuestionEvaluation;
import main.model.entities.RubriqueQuestion;
@Repository
public interface QuestionEvaluationRepository extends CrudRepository<QuestionEvaluation,Long>{
	@Query(value = "SELECT qe FROM QuestionEvaluation qe where qe.idQuestion=?1 ")
	public QuestionEvaluation findByQuestionEvaluation(Question question);

}
