package com.yong.book.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yong.book.book.api.BookRequest;

@RestController
public class BookController {
	@GetMapping("/book/find")
	public String find(BookRequest request) {
		return request.toQueryString();
	}
}
