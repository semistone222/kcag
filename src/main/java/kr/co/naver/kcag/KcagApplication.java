package kr.co.naver.kcag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kr.co.naver.kcag.domain.Answer;
import kr.co.naver.kcag.domain.Question;
import kr.co.naver.kcag.persistence.QuestionRepository;

@SpringBootApplication
public class KcagApplication {
	private static final Logger log = LoggerFactory.getLogger(KcagApplication.class);

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
			firstQuestion.addAnswers(new Answer(firstQuestion.getQuestionId(), "1번 질문 1번 대답"));
			firstQuestion.addAnswers(new Answer(firstQuestion.getQuestionId(), "1번 질문 2번 대답"));
			firstQuestion.addAnswers(new Answer(firstQuestion.getQuestionId(), "1번 질문 3번 대답"));
			secondQuestion.addAnswers(new Answer(secondQuestion.getQuestionId(), "2번 질문 1번 대답"));
			secondQuestion.addAnswers(new Answer(secondQuestion.getQuestionId(), "2번 질문 2번 대답"));
			thirdQuestion.addAnswers(new Answer(thirdQuestion.getQuestionId(), "3번 질문 1번 대답"));

			// save to repository
			repository.save(firstQuestion);
			repository.save(secondQuestion);
			repository.save(thirdQuestion);
			
			// fetch all questions
			log.info("Questions found with findAll():");
			log.info("-------------------------------");
			for (Question question : repository.findAll()) {
				log.info(question.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Question question = repository.findOne(1L);
			log.info("Question found with findOne(1L):");
			log.info("--------------------------------");
			log.info(question.toString());
			log.info("");
		};
	}
}
