package main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.PaysViewBusiness;
import main.model.entities.PaysView;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Pays")
public class PaysViewWebService {
	
	@Autowired
	PaysViewBusiness business;
	
	@GetMapping()
	public List <PaysView> getAll() {
		return business.getAll();
	}

}
