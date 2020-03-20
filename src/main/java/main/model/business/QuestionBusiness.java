package main.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		Qualificatif qualificatif = qualificatifRepository.findById(question.getQualificatif().getIdQualificatif())
				.get();
		if (questions.isEmpty()) {
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
			System.out.println("le question est déjà referencier");
			return false;
		}
		questionRepository.delete(question);
		System.out.println("question supprimer");
		return true;
	}
	
	
	public boolean updateQuestion(Question question) {
		RubriqueQuestion rebriqueQuestion = RQuestion.findByQuestion(question);

		if (rebriqueQuestion != null) {
			System.out.println("le question est déjà referencier");
			return false;
		}
		questionRepository.save(question);
		return true;
	}

}
