package com.yong.book.book.api.request;

import com.yong.book.book.api.ApiRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest implements ApiRequest {
	private String query;
	private Integer page;
	private Integer size;
	private Integer category;
	private SortType sort;
	private TargetType target;

	public String toQueryString() {
		if(query == null) {
			throw new IllegalStateException("query is null");
		}

		return String.format("query=%s&page=%s&size=%s&category=%s&sort=%s&target=%s", query, ifNull(page), ifNull(size), ifNull(category), ifNull(sort), ifNull(target));
	}

	private String ifNull(Object target) {
		return target == null ? "" : String.valueOf(target);
	}
}
