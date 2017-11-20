package kr.co.naver.kcag.presentation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionControllerTest {

	@Autowired
	WebApplicationContext wac;
	MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.wac)
			.alwaysDo(print(System.out))
			.build();
	}

	@Test
	public void shouldCreate() throws Exception {
		String requestBody = "{\"title\":\"질문이 있습니다.\", \"content\":\"이런 질문에 대해서 어떻게 생각하십니까?\"}";

		mvc.perform(
			post("/api/questions/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
			)
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.questionId").exists())
			.andExpect(jsonPath("$.title").value("질문이 있습니다."))
			.andExpect(jsonPath("$.content").value("이런 질문에 대해서 어떻게 생각하십니까?"))
			.andExpect(jsonPath("$.answers").isEmpty())
			.andExpect(jsonPath("$.keywords").isEmpty())
			.andExpect(jsonPath("$.createdAt").exists());
	}

	@Test
	public void shouldDelete() throws Exception {
		mvc.perform(
			delete("/api/questions/1")
				.contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNoContent());
	}
}
