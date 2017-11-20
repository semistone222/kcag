package kr.co.naver.kcag.service;

import org.springframework.stereotype.Service;

import kr.co.naver.kcag.domain.Answer;
import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.persistence.AnswerRepository;
import kr.co.naver.kcag.persistence.QuestionRepository;

@Service
public class AnswerService {
	private AnswerRepository answerRepository;
	private QuestionRepository questionRepository;
	
	public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
	}
	
	public Question create(Answer answer) {
		Question question = questionRepository.findOne(answer.getQuestionId());
		question.addAnswer(answer);
		question = questionRepository.save(question);
		return question;
	}
	
	public Answer findById(Long id) {
		return answerRepository.findOne(id);
	}
	
	public Iterable<Answer> findAll() {
		return answerRepository.findAll();
	}
	
	public void delete(Long id) {
		Answer answer = answerRepository.findOne(id);
		Question question = questionRepository.findOne(answer.getQuestionId());
		question.removeAnswer(answer);
		question = questionRepository.save(question);
	}
}
