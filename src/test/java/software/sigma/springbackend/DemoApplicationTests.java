package software.sigma.springbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
				.alwaysDo(document("{method-name}",
						preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
				.build();
	}


	@Test
	public void crudCreateExample() throws Exception {
		Map<String, Object> crud = new HashMap<>();
		crud.put("firstname", "User");
		crud.put("lastname", "Test");
		crud.put("email", "user.test@mailforspam.com");
		crud.put("password", "password!");

		this.mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsString(crud)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(document("create-crud-example",
						requestFields(fieldWithPath("firstname").description("User's firstname"),
								fieldWithPath("lastname").description("User's lastname"),
								fieldWithPath("email").description("User's email"),
								fieldWithPath("password").description("User's password (min length of 5)")
								)));
	}

}

