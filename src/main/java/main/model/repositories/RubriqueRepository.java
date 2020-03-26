package main.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Rubrique;


@Repository
public interface RubriqueRepository extends CrudRepository<Rubrique, Long> {
	
	@Query(value = "SELECT max(id_Rubrique) FROM rubrique ",   nativeQuery = true)
	public Long getMaxId();
	
	@Query(value = "SELECT * FROM rubrique ORDER BY designation ", nativeQuery = true)
	public List<Rubrique> findAll();
	

	
}
