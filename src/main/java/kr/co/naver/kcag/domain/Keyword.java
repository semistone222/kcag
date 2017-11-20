package kr.co.naver.kcag.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="KEYWORD")
public class Keyword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long keywordId;
	private Long questionId;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	public Keyword() {
		
	}
	
	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Keyword [keywordId=" + keywordId + ", questionId=" + questionId + ", content=" + content
				+ ", createdAt=" + createdAt + "]";
	}
}
