package com.yong.book.book;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yong.book.book.api.KakaoApiRepository;
import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.api.response.BookResponse;
import com.yong.book.book.exception.BookNotFoundException;
import com.yong.book.book.history.History;
import com.yong.book.book.history.HistoryRepository;
import com.yong.book.member.Member;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	@InjectMocks
	private BookService bookService;
	@Mock
	private KakaoApiRepository kakaoApiRepository;

	@Test(expected = BookNotFoundException.class)
	public void searchAndHistory() {
		// given
		BookRequest bookRequest = createBookReuqest("미움받을 용기");
		given(kakaoApiRepository.call(bookRequest)).willReturn(null);

		// when
		bookService.searchAndHistory(bookRequest, "");
	}

	private BookRequest createBookReuqest(String query) {
		return new BookRequest(query, null, null, null, null, null);
	}
}