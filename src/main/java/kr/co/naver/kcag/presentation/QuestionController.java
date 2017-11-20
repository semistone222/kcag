package kr.co.naver.kcag.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
private final Logger log = LoggerFactory.getLogger(QuestionController.class);
	
	private final QuestionService questionService;
	
	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Question create(@RequestBody Question question) {
		Question newQuestion = questionService.create(question);
		log.info("question crated : {}", newQuestion);
		return newQuestion;
	}

	
	@GetMapping("/{id}")
	Question find(@PathVariable Long id) {
		Question question = questionService.findById(id);
		log.info("find a question : {}", question);
		return question;
	}
	
	@GetMapping
	Iterable<Question> findAll() {
		Iterable<Question> questions = questionService.findAll();
		for(Question question : questions) {
			log.info("find all question : {}", question);
		}
		return questions;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Long id) {
		questionService.delete(id);
	}
}
