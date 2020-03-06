package main.model.business;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.entities.Promotion;
import main.model.repositories.PromotionRepository;
import main.model.repositories.QualificatifRepository;

@Resource
public class PromotionBusiness {
	@Autowired
	private PromotionRepository promotionRepo;
}
