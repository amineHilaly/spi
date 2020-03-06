package main.model.business;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import main.model.repositories.EtudiantRepository;

@Resource
public class EtudiantBusiness {
	@Autowired
	private EtudiantRepository etudiantRepo;
}
