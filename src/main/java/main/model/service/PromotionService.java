package main.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.PromotionBusiness;
import main.model.entities.Promotion;
import main.model.entities.PromotionPK;

@RestController
public class PromotionService {
	@Autowired
	PromotionBusiness promotionBusiness;
	
	@RequestMapping(value="/promotions", method=RequestMethod.GET)
	public List<Promotion> getAllPromotion(){
		return promotionBusiness.getAllPromotion();
		
	}
	
	@RequestMapping(value="/promotion", method=RequestMethod.GET)
	public Optional<Promotion> findromotion(@RequestBody PromotionPK pk) {
		
		return promotionBusiness.findPromotion(pk);
		
	}
		
}
