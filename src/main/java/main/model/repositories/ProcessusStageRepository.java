package main.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.ProcessusStage;
import main.model.entities.Qualificatif;


@Repository
public interface ProcessusStageRepository extends CrudRepository<ProcessusStage, String> {
	
	
 
	
}
