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

import kr.co.naver.kcag.domain.Answer;
import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.service.AnswerService;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
	private final Logger log = LoggerFactory.getLogger(AnswerController.class);
	
	private final AnswerService answerService;
	
	@Autowired
	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Question create(@RequestBody Answer answer) {
		Question questionWithNewAnswer = answerService.create(answer);
		log.info("question with new answer : {}", questionWithNewAnswer);
		return questionWithNewAnswer;
	}

	
	@GetMapping("/{id}")
	Answer find(@PathVariable Long id) {
		return answerService.findById(id);
	}
	
	@GetMapping
	Iterable<Answer> findAll() {
		return answerService.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Long id) {
		answerService.delete(id);
	}
}
