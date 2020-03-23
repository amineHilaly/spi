package main.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.PaysView;
import main.model.repositories.EtudiantRepository;
import main.model.repositories.PaysViewRepository;

@Repository
public class PaysViewBusiness {
	
	@Autowired
	private PaysViewRepository paysRepo;
	
	public List<PaysView> getAll(){
		return (List<PaysView>) paysRepo.findAll();
	}
	
	

}
