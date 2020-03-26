package main.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.UniversiteView;
import main.model.repositories.EtudiantRepository;
import main.model.repositories.UniversiteViewRepository;

@Repository
public class UniversiteViewBusiness {
	
	@Autowired
	private UniversiteViewRepository univRepo;
	
	public List<UniversiteView> getAll(){
		return (List<UniversiteView>) univRepo.findAll();
	}
	
	

}
