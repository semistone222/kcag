package kr.co.naver.kcag.service;

import org.springframework.stereotype.Service;

import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.persistence.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public Question create(Question question) {
		return questionRepository.save(question);
	}
	
	public Question findById(Long id) {
		return questionRepository.findOne(id);
	}
	
	public Iterable<Question> findAll() {
		return questionRepository.findAll();
	}
	
	public void delete(Long id) {
		questionRepository.delete(id);
	}
}
