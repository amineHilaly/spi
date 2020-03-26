package main.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.UniteEnseignement;
import main.model.repositories.UniteEnseignementRepository;

@Repository
public class UniteEnseignementBusiness {

	
	@Autowired
	private UniteEnseignementRepository uniteEnseignementRepo;
	
	
	public List<UniteEnseignement> rechercherParFormation(String codeFormation) {
		return uniteEnseignementRepo.findUniteEnseignementByFormationCodeFormation(codeFormation);
	}

	public List<UniteEnseignement> rechercherParEnseignant(int noEnseignant) {
		List<UniteEnseignement> ueRecherche = uniteEnseignementRepo.findByEnseignantNoEnseignant(noEnseignant);		
		return ueRecherche;
	}

	public List<UniteEnseignement> rechercherParFormationEnseignant(String codeFormation, int noEnseignant) {
		List<UniteEnseignement> ueRecherche = uniteEnseignementRepo.findUniteEnseignementByFormationCodeFormationAndEnseignantNoEnseignant(codeFormation,noEnseignant);		
		return ueRecherche;
	}
}
