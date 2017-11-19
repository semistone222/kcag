package kr.co.naver.kcag.service;

import org.springframework.stereotype.Service;

import kr.co.naver.kcag.domain.Answer;
import kr.co.naver.kcag.persistence.AnswerRepository;

@Service
public class AnswerService {
	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public Answer create(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Answer findById(Long id) {
		return answerRepository.findOne(id);
	}
	
	public Iterable<Answer> findAll() {
		return answerRepository.findAll();
	}
	
	public void delete(Long id) {
		answerRepository.delete(id);
	}
}
