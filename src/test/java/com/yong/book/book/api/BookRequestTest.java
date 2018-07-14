package com.yong.book.book.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.api.request.SortType;
import com.yong.book.book.api.request.TargetType;

public class BookRequestTest {

	@Test
	public void toQueryString() {
		BookRequest request = new BookRequest("미움받을 용기",1, 2, 900, SortType.RECENCY, TargetType.CONTENTS);

		String actual = request.toQueryString();
		String expected = "query=미움받을 용기&page=1&size=2&category=900&sort=RECENCY&target=CONTENTS";
		assertThat(actual, is(expected));
	}
}