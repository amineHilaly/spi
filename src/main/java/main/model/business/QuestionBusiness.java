package main.model.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.entities.Etudiant;
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

		return (List<Question>) questionRepository.findAll();
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
	
	
	public boolean updateQuestion(Question question) {
		RubriqueQuestion rebriqueQuestion = RQuestion.findByQuestion(question);

		if (rebriqueQuestion != null) {
			System.out.println("la question est déjà referenciée");
			return false;
		}
		questionRepository.save(question);
		return true;
	}
	

}
