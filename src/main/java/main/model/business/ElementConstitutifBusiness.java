package main.model.business;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.ElementConstitutif;
import main.model.entities.Etudiant;
import main.model.entities.UniteEnseignementPK;
import main.model.repositories.ElementConstitutifRepository;


@Repository
public class ElementConstitutifBusiness {
	
	@Autowired
	private ElementConstitutifRepository elementConstitutifRepo;
	
	/*
	 * public void creerElementConstitutif(ElementConstitutif elementConstitutif) {
	 * elementConstitutifRepo.save(elementConstitutif ); }
	 */
	
	/*
	 * public void updateEtudiant(ElementConstitutif elementConstitutif) {
	 * elementConstitutifRepo.save(elementConstitutif); }
	 */
	
	
	public List<ElementConstitutif> getAllElementConstitutif(){
		return (List<ElementConstitutif>) elementConstitutifRepo.findAll();
	}
	
	
	public List<ElementConstitutif> getElementConstitutifByUE(String codeUe, String codeFormation) {
		UniteEnseignementPK ue = new UniteEnseignementPK(codeFormation, codeUe);
		return elementConstitutifRepo.findByUniteEnseignementId(ue);
	}
	
	

	
}
