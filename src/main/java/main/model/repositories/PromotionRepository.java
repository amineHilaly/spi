package main.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Promotion;
import main.model.entities.PromotionPK;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {

}
