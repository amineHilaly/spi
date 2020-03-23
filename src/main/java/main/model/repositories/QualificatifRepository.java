package main.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Qualificatif;


@Repository
public interface QualificatifRepository extends CrudRepository<Qualificatif, Long> {
	
	@Query(value = "SELECT max(id_Qualificatif) FROM qualificatif ",   nativeQuery = true)
	public Long getMaxId(); 
	
}
