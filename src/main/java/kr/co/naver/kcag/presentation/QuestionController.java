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
		return questionService.findById(id);
	}
	
	@GetMapping
	Iterable<Question> findAll() {
		return questionService.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Long id) {
		questionService.delete(id);
	}
}
