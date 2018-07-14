package com.yong.book.book.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.api.response.BookResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaoApiRepositoryTest {
	@Autowired
	private KakaoApiRepository kakaoApiRepository;

	@Test
	public void call() {
		BookRequest request = new BookRequest("미움받을 용기", null, null, null, null, null);
		BookResponse bookResponse = kakaoApiRepository.call(request);

		assertThat(bookResponse, is(notNullValue()));
		assertThat(bookResponse.getDocuments(), is(notNullValue()));
		assertThat(bookResponse.getMeta(), is(notNullValue()));
	}
}