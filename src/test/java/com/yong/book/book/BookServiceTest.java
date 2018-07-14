package com.yong.book.book;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.yong.book.book.api.KakaoApiRepository;
import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.exception.BookNotFoundException;

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