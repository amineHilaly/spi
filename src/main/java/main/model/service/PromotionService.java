package main.model.service;

import java.util.List;
import java.util.Optional;

//import javax.validation.Validation;
//import javax.validation.ValidatorFactory;
//import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.EtudiantBusiness;
import main.model.business.PromotionBusiness;
import main.model.entities.Etudiant;
import main.model.entities.Promotion;
import main.model.entities.PromotionPK;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionService {
	@Autowired
	PromotionBusiness promotionBusiness;
	
	
	
	
	@RequestMapping(value="/promotions", method=RequestMethod.GET)
	@GetMapping()
	public List<Promotion> getAllPromotion(){
		
		System.out.println();
		return promotionBusiness.getAllPromotion();
		
	}
	
	@RequestMapping(value="/promotions", method=RequestMethod.POST)
	//@GetMapping()
	public Promotion findpromotion(@RequestBody PromotionPK pk) {
		
		System.out.println(pk);
		Optional<Promotion> promotionOp= promotionBusiness.findPromotion(pk);
		Promotion promotion = promotionOp.get();
		return promotion;
		
	}
		
	@RequestMapping(value="/Addpromotions", method=RequestMethod.POST)
	//@GetMapping()
	public boolean savePromotion(@RequestBody Promotion promotion) {
		
    return promotionBusiness.SavePromotion(promotion);
		
	}
	
	@RequestMapping(value="/Updatepromotions", method=RequestMethod.PUT)
	//@GetMapping()
	public boolean updatePromotion(@RequestBody Promotion promotion) {
		
    return promotionBusiness.UpdatePromotion(promotion);
		
	}
	
	
	
	@RequestMapping(value="/Deletepromotion", method=RequestMethod.DELETE)
	public void DeletePromotion(@RequestBody PromotionPK promotion) {
		promotionBusiness.deletePromotion(promotion);
		System.out.println("bien supprimé");
		
	}
	
	@RequestMapping(value="/Etudiantspromotion", method=RequestMethod.POST)
	public List<Etudiant> EtudiantsByPromotion(@RequestBody PromotionPK pk) {
		System.out.println(pk);
		System.out.println(promotionBusiness.EtudiantByPromotion(pk));
		return promotionBusiness.EtudiantByPromotion(pk);
	}
}
