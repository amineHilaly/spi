package main.model.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import main.model.business.QualificatifBusiness;
import main.model.entities.Qualificatif;


@RestController
@RequestMapping("Qualificatif")
public class QualificatifWebService {
	
	
	@Autowired
	QualificatifBusiness business;
	
	@GetMapping()
	public List <Qualificatif> getAll() {
		return business.getAll();
	}
	
	@GetMapping("/{idsent}")
	public Qualificatif getId(@PathVariable long idsent) {
		Long id = new Long(idsent);
		return business.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable long id) {
		Qualificatif qualifactif = new Qualificatif();
		qualifactif.setIdQualificatif(id);
		return business.delete(qualifactif);
	}
	
	@PostMapping()
	public void create(@RequestBody Qualificatif qualificatif) {
		business.create(qualificatif);
	}
	
	
	@PutMapping()
	public void update(@RequestBody Qualificatif qualificatif) {
		business.update(qualificatif);
	}
	
}
