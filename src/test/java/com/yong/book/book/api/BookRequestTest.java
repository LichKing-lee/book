package com.yong.book.book.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class BookRequestTest {

	@Test
	public void toQueryString() {
		BookRequest request = new BookRequest(1, 2, 900, SortType.RECENCY, TargetType.CONTENTS);

		String actual = request.toQueryString();
		String expected = "page=1&size=2&category=900&sort=RECENCY&target=CONTENTS";
		assertThat(actual, is(expected));
	}
}