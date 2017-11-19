package kr.co.naver.kcag.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="QUESTION")
public class Question {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long questionId;
		private String title;
		private String content;
		@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
		private Collection<Answer> answers = new ArrayList<Answer>();
		@Temporal(TemporalType.TIMESTAMP)
		private Date createdAt = new Date();
		
		public Question() {
			
		}
		
		public Question(String title, String content) {
			this.title = title;
			this.content = content;
		}
		
		public Long getQuestionId() {
			return questionId;
		}

		public void setQuestionId(Long questionId) {
			this.questionId = questionId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Collection<Answer> getAnswers() {
			return answers;
		}

		public void setAnswers(Collection<Answer> answers) {
			this.answers = answers;
		}
		
		public void addAnswers(Answer answer) {
			this.answers.add(answer);
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "Question [questionId=" + questionId + ", title=" + title + ", content=" + content + ", answers="
					+ answers + ", createdAt=" + createdAt + "]";
		}
}
