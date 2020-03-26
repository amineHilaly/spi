package main.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import main.model.entities.Qualificatif;
import main.model.entities.Question;
import main.model.entities.Rubrique;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	public List<Question> findByQualificatif(Qualificatif qualificatif);

	public List<Question> findByIntitule(String intitule);

	@Query(value = "SELECT max(ID_QUESTION) FROM question", nativeQuery = true)
	public Long getMaxId();
	
	@Query(value = "SELECT * FROM question ORDER BY intitule ", nativeQuery = true)
	public List<Question> findAll();
}
