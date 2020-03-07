package main.model.business;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.entities.Etudiant;
import main.model.repositories.EtudiantRepository;

@Resource
public class EtudiantBusiness {
	@Autowired
	private EtudiantRepository etudiantRepo;
	
	public void creerEtudiant(List<Etudiant> etudiant) {
		etudiantRepo.saveAll(etudiant );
	}
	
	public void updateEtudiant(Etudiant etudiant) {
		etudiantRepo.save(etudiant);
	}
	
	
	public Collection<Etudiant> getAllEtudiants(){
		return (Collection<Etudiant>) etudiantRepo.findAll();
	}
	
	
	public Optional<Etudiant> getEtudiantById(String noEtudiant) {
		return etudiantRepo.findById(noEtudiant);
	}
	
	
	public void deleteEtudiantById(String noEtudiant) {
		etudiantRepo.deleteById(noEtudiant); 
		
	}
	
	public void deleteAllEtudiants() {
		etudiantRepo.deleteAll();
	}
	
	
}
