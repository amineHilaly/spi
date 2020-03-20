package main.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.model.entities.UniteEnseignement;
import main.model.entities.UniteEnseignementPK;


public interface UniteEnseignementRepository extends CrudRepository<UniteEnseignement, UniteEnseignementPK>  {

	List<UniteEnseignement> findUniteEnseignementByFormationCodeFormation(String codeFormation);
	List<UniteEnseignement> findByEnseignantNoEnseignant(int noEnseignant);
	List<UniteEnseignement> findUniteEnseignementByFormationCodeFormationAndEnseignantNoEnseignant(String codeFormation,int noEnseignant);

}