package com.yong.book.bookmark;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithUserDetails("lcy0202")
public class BookmarkControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test() throws Exception {
		// 추가
		mockMvc.perform(post("/bookmark")
			.contentType(MediaType.APPLICATION_JSON)
			.content("hello"))
			.andExpect(status().isOk());

		// 조회(추가확인)
		mockMvc.perform(get("/bookmark")
		.param("page", "0")
		.param("sort", "title"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.bookmarks.length()").value(1));

		// 삭제
		mockMvc.perform(delete("/bookmark")
			.contentType(MediaType.APPLICATION_JSON)
			.content("1"))
			.andExpect(status().isOk());

		// 조회(삭제확인)
		mockMvc.perform(get("/bookmark")
			.param("page", "0")
			.param("sort", "insertDatetime"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.bookmarks.length()").value(0));
	}
}