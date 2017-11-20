package kr.co.naver.kcag;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kr.co.naver.kcag.domain.Answer;
import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.persistence.QuestionRepository;

@SpringBootApplication
public class KcagApplication {
	public static void main(String[] args) {
		SpringApplication.run(KcagApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(QuestionRepository repository) {
		return (args) -> {
			// create a couple of question instances
			Question firstQuestion = new Question("1번 질문 제목", "1번 질문 내용");
			Question secondQuestion = new Question("2번 질문 제목", "2번 질문 내용");
			Question thirdQuestion = new Question("3번 질문 제목", "3번 질문 내용");
			
			// save to repository
			firstQuestion = repository.save(firstQuestion);
			secondQuestion = repository.save(secondQuestion);
			thirdQuestion = repository.save(thirdQuestion);
			
			// add a couple of answers
			firstQuestion.addAnswer(new Answer(firstQuestion.getQuestionId(), "1번 질문 1번 대답"));
			firstQuestion.addAnswer(new Answer(firstQuestion.getQuestionId(), "1번 질문 2번 대답"));
			firstQuestion.addAnswer(new Answer(firstQuestion.getQuestionId(), "1번 질문 3번 대답"));
			secondQuestion.addAnswer(new Answer(secondQuestion.getQuestionId(), "2번 질문 1번 대답"));
			secondQuestion.addAnswer(new Answer(secondQuestion.getQuestionId(), "2번 질문 2번 대답"));
			thirdQuestion.addAnswer(new Answer(thirdQuestion.getQuestionId(), "3번 질문 1번 대답"));

			// save to repository
			repository.save(firstQuestion);
			repository.save(secondQuestion);
			repository.save(thirdQuestion);
		};
	}
}
