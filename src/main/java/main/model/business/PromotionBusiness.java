package main.model.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.entities.Etudiant;
import main.model.entities.Evaluation;
import main.model.entities.Promotion;
import main.model.entities.PromotionPK;
import main.model.entities.Qualificatif;
import main.model.repositories.EtudiantRepository;
import main.model.repositories.EvaluationRepository;
import main.model.repositories.PromotionRepository;
import main.model.repositories.QualificatifRepository;

@Repository
public class PromotionBusiness {
	@Autowired
	private PromotionRepository promotionRepo;
	@Autowired
	private EtudiantRepository etudiantRepo;
	
	@Autowired
	private EvaluationRepository evaluationRepo;
	
	
	
	public List<Promotion> getAllPromotion(){
		List<Promotion> promotions = (List<Promotion>) promotionRepo.findAll();
		
		Collections.sort(promotions);
		for(Object[] Nbretudiant: promotionRepo.getNbEtudiant()) {
			for(int i=0;i<promotions.size();i++)  {
				if(promotions.get(i).getPromotionPK().getAnneeUniversitaire().equals(Nbretudiant[0]) && promotions.get(i).getPromotionPK().getFormation().getCodeFormation().equals(Nbretudiant[1]) ) {
					String s= ""+Nbretudiant[2];
					promotions.get(i).setNbrEtudiant((Integer.parseInt(s)));
					System.out.println(Nbretudiant[2]);
				}
			}
		}
		System.out.println(promotions);
		return promotions ;
	}
	public Optional<Promotion> findPromotion(PromotionPK pk) {
		return promotionRepo.findById(pk);
	}
	
	public boolean SavePromotion(Promotion promotion) {
		
		promotionRepo.save(promotion);
		return true;
		
	}
	
	
	public boolean UpdatePromotion(Promotion promotion) {
		
		promotionRepo.save(promotion);
		return true;
		
	}


	public boolean deletePromotion(PromotionPK pk) {
		
		List<Etudiant> listEtudiant=null;
		Promotion promotion = promotionRepo.findById(pk).get();
		listEtudiant = etudiantRepo.findByPromotion(promotion);
		if(listEtudiant.isEmpty()) {
			promotionRepo.delete(promotion);
			return true;
		}
		
		return false;
	}
	
	public List<Etudiant> EtudiantByPromotion(PromotionPK promotionpk){
		Promotion promotion = promotionRepo.findById(promotionpk).get();
		return etudiantRepo.findByPromotion(promotion);
	}
	
	
	public List<Evaluation> evaluationtByPromotion(PromotionPK promotionpk){
		Promotion promotion = promotionRepo.findById(promotionpk).get();
		return evaluationRepo.findByPromotion(promotion);
	}
	
		
}
