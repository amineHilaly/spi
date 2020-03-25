package main.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.model.business.QuestionBusiness;
import main.model.entities.Etudiant;
import main.model.entities.Promotion;
import main.model.entities.Qualificatif;
import main.model.entities.Question;
import main.model.entities.RubriqueQuestion;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionService {

	@Autowired
	QuestionBusiness questionBusiness;

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	@GetMapping()
	public List<Question> getAllQuestion() {

		return questionBusiness.getAllQuestion();

	}

	@RequestMapping(value = "/question", method = RequestMethod.POST)
	@GetMapping()
	public List<Question> getQuestion(@RequestBody Question question) {
		return questionBusiness.findQuestion(question);

	}

	@RequestMapping(value = "/Addquestion", method = RequestMethod.POST)
	@GetMapping()
	public Boolean addQuestion(@RequestBody Question question) {
		return questionBusiness.saveQuestion(question);

	}
	
	
	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
	@GetMapping()	
	public boolean deleteQuestion(@RequestBody Question question) {
		return questionBusiness.deleteQuestion(question);

	}

	@RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
	@GetMapping()
	public boolean updateQuestion(@RequestBody Question question) {
		System.out.println(question);

		return questionBusiness.updateQuestion(question);
		

	}
	@DeleteMapping("/Questions/{id}")
	public boolean delete(@PathVariable long id) {
		
			Question question = new Question();
			question.setIdQuestion(id);
			boolean res = questionBusiness.deleteQuestion(question); 
			return res;
		
	}
	
	

}
