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


import main.model.business.QualificatifBusiness;
import main.model.entities.ProcessusStage;
import main.model.entities.Qualificatif;
import main.model.repositories.ProcessusStageRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Domaines")
public class ProcessusStageWebService {
	
	
	@Autowired
	ProcessusStageRepository ProcessStage;
	
	@GetMapping()
	public List <ProcessusStage> getAll() {
		return (List<ProcessusStage>) ProcessStage.findAll();
	}
	
	
}
