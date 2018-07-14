package com.yong.book.book;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.api.response.BookResponse;
import com.yong.book.login.LoginUserDetails;

@RestController
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/book/search")
	public BookResponse search(@AuthenticationPrincipal LoginUserDetails loginUserDetails, BookRequest request) {

		return bookService.searchAndHistory(request, loginUserDetails.getUsername());
	}
}
