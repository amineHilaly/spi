package main.model.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.Qualificatif;
import main.model.entities.Question;
import main.model.repositories.QualificatifRepository;
import main.model.repositories.QuestionRepository;

@Repository
public class QualificatifBusiness {
	@Autowired
	private QualificatifRepository qualificatifRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	
	
	public void create(Qualificatif qualificatif) {
		qualificatif.setIdQualificatif(qualificatifRepo.getMaxId()+1);
		qualificatifRepo.save(qualificatif);
	}
	
	public void update(Qualificatif qualificatif) {
		qualificatifRepo.save(qualificatif);
	}
	
	public boolean delete(Qualificatif qualificatif) {
		List<Question> questions = questionRepo.findByQualificatif(qualificatif);
		if(questions.isEmpty()) {
			qualificatifRepo.delete(qualificatif);
			return true;
		}
		return false;
	}
	
	public List<Qualificatif> getAll(){
		List<Qualificatif> qualificatifs = new ArrayList<Qualificatif>();
		for (Qualificatif q : qualificatifRepo.findAll()) {
			qualificatifs.add(q);
		}
		return qualificatifs;
	}
	
	public Qualificatif getById(Long id) {
		return qualificatifRepo.findById(id).get();
	}
	
}
