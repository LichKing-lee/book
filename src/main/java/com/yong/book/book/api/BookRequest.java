package com.yong.book.book.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest {
	private Integer page;
	private Integer size;
	private Integer category;
	private SortType sort;
	private TargetType target;

	public String toQueryString() {
		return String.format("page=%s&size=%s&category=%s&sort=%s&target=%s", ifNull(page), ifNull(size), ifNull(category), ifNull(sort), ifNull(target));
	}

	private String ifNull(Object target) {
		return target == null ? "" : String.valueOf(target);
	}
}
