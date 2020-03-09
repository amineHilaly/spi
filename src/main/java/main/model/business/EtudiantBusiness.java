package main.model.business;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.Etudiant;
import main.model.entities.Promotion;
import main.model.repositories.EtudiantRepository;
import main.model.repositories.PromotionRepository;

@Repository
public class EtudiantBusiness {
	@Autowired
	private EtudiantRepository etudiantRepo;
	
	public void creerEtudiant(Etudiant etudiant) {
		etudiantRepo.save(etudiant );
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
	
	public List<Etudiant> findByPromotion(Promotion promo){
		//return etudiantRepo.findByPromotion();
		return etudiantRepo.findByPromotion(promo);
		
	}
	
	
}
