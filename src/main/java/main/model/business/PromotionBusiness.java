package main.model.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.entities.Promotion;
import main.model.entities.PromotionPK;
import main.model.entities.Qualificatif;
import main.model.repositories.PromotionRepository;
import main.model.repositories.QualificatifRepository;

@Repository
public class PromotionBusiness {
	@Autowired
	private PromotionRepository promotionRepo;
	
	
	
	
	public List<Promotion> getAllPromotion(){
		
	return (List<Promotion>) promotionRepo.findAll();
	}
	
	
	public Optional<Promotion> findPromotion(PromotionPK pk) {
		return promotionRepo.findById(pk);
	}
	
	
		
}
