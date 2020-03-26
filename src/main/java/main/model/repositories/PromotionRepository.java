package main.model.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Promotion;
import main.model.entities.PromotionPK;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {
	
	@Query(value = "select p.annee_universitaire,p.code_formation, COUNT(p.code_formation) from promotion p, etudiant e where e.code_formation=p.code_formation and e.annee_universitaire=p.annee_universitaire group by p.code_formation,p.annee_universitaire",   nativeQuery = true)
	public List<Object[]> getNbEtudiant(); 
}
