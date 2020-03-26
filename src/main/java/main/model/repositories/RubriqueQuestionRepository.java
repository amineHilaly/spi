package main.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Question;
import main.model.entities.RubriqueQuestion;
import main.model.entities.RubriqueQuestionPK;
@Repository
public interface RubriqueQuestionRepository extends CrudRepository<RubriqueQuestion, RubriqueQuestionPK> {
	@Query(value = "SELECT r FROM RubriqueQuestion r where r.question=?1 ")
	public RubriqueQuestion findByQuestion(Question question);


	/*@Query(value = "SELECT * FROM RUBRIQUE_QUESTION where ID_QUESTION=?1 ",   nativeQuery = true)
	public Long getIdQuestion(long);*/
}
