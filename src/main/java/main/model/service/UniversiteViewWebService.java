package main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.UniversiteViewBusiness;
import main.model.entities.UniversiteView;

@RestController
@RequestMapping("Universites")
public class UniversiteViewWebService {
	
	@Autowired
	UniversiteViewBusiness business;
	
	@GetMapping()
	public List <UniversiteView> getAll() {
		return business.getAll();
	}

}
