package com.yong.book.book.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
	@JsonProperty("total_count")
	private int totalCount;
	@JsonProperty("pageable_count")
	private int pageableCount;
	@JsonProperty("is_end")
	private boolean isEnd;
}
