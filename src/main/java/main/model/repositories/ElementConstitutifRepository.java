package main.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.model.entities.ElementConstitutif;
import main.model.entities.ElementConstitutifPK;
import main.model.entities.UniteEnseignementPK;

public interface ElementConstitutifRepository extends CrudRepository<ElementConstitutif, ElementConstitutifPK>  {

	List<ElementConstitutif> findByUniteEnseignementId(UniteEnseignementPK ue);
	
}