package main.model.business;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.entities.Qualificatif;
import main.model.entities.Question;
import main.model.entities.RubriqueQuestion;
import main.model.repositories.QualificatifRepository;
import main.model.repositories.QuestionRepository;
import main.model.repositories.RubriqueQuestionRepository;

@Repository
public class QuestionBusiness {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	private QualificatifRepository qualificatifRepository;

	@Autowired
	private RubriqueQuestionRepository RQuestion;

	public List<Question> getAllQuestion() {
		
        List <Question> questions = (List<Question>) questionRepository.findAll();
		Collections.sort(questions);
		return questions;
	}

	public List<Question> findQuestion(Question question) {

		return questionRepository.findByIntitule(question.getIntitule());
	}

	public boolean saveQuestion(Question question) {
		List<Question> questions = this.findQuestion(question);
		List<Question> intit = this.getAllQuestion();
        boolean intituTrouv=false;
        for(int i=0;i<intit.size();i++) {
        	
        	if(intit.get(i).getIntitule().equals(question.getIntitule())){
        		
        		intituTrouv= true;
        	}
        	
        	
        	
        }
		Qualificatif qualificatif = qualificatifRepository.findById(question.getQualificatif().getIdQualificatif())
				.get();
		if (questions.isEmpty() & !intituTrouv) {
			   
			if (qualificatif != null) {
				question.setIdQuestion(questionRepository.getMaxId() + 1);
				questionRepository.save(question);
				System.out.println("question bien ajouter");
				return true;
			}
		}
		System.out.println("question déjà existe");
		return false;
	}

	
	
	
	public boolean updateQuestion(Question question) {
		List<Question> intit = this.getAllQuestion();
        int j =0;
        for(int i=0;i<intit.size();i++) {
        	
        	if(intit.get(i).getIntitule().equals(question.getIntitule()) & intit.get(i).getIdQuestion() != question.getIdQuestion() ){
        		j++;
        	}
        	
        	
        	
        }
		RubriqueQuestion rebriqueQuestion = RQuestion.findByQuestion(question);

		
	    if(j>0){
			System.out.println("l'intitulé existe déja");

			return false;
	
		}
		
		questionRepository.save(question);
		return true;
	}
	public boolean deleteQuestion(Question question) {
		RubriqueQuestion rebriqueQuestion = RQuestion.findByQuestion(question);

		if (rebriqueQuestion != null) {
			System.out.println("le question est déjà referenciée");
			return false;
		}
		questionRepository.delete(question);
		System.out.println("question supprimée");
		return true;
	}
	public boolean ref(Question question) {
		RubriqueQuestion rebriqueQuestion = RQuestion.findByQuestion(question);

		if (rebriqueQuestion != null) {
			System.out.println("le question est déjà referenciée");
			return true;
		}
		return false;
		
	}

}
