package main.model.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.EtudiantBusiness;
import main.model.business.QualificatifBusiness;
import main.model.entities.Qualificatif;
import main.model.repositories.EtudiantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "Qualificatif" , produces = "application/json; charset=utf-8")
public class QualificatifWebService {
	
	
	@Autowired
	QualificatifBusiness business;
	
	
	@GetMapping()
	@RequestMapping(produces = "application/json; charset=utf-8")
	public List <Qualificatif> getAll() {
		try {
			return business.getAll();
		}catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{idsent}")
	public Qualificatif getById(@PathVariable long idsent) {
		try {
			return business.getById(Long.valueOf(idsent));
		}catch (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable long id) {
		try {
			Qualificatif qualifactif = new Qualificatif();
			qualifactif.setIdQualificatif(id);
			boolean res = business.delete(qualifactif); 
			return res;
		}catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping()
	public boolean create(@RequestBody Qualificatif qualificatif) {
		try {
			business.create(qualificatif);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	@PutMapping()
	public boolean update(@RequestBody Qualificatif qualificatif) {
		try {
			return business.update(qualificatif);
		}catch (Exception e) {
			return false;
		}
	}
	
}
