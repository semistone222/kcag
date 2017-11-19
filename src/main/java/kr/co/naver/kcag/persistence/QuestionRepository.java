package kr.co.naver.kcag.persistence;

import org.springframework.data.repository.CrudRepository;

import kr.co.naver.kcag.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
