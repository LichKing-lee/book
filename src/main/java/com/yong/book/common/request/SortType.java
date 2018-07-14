package com.yong.book.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
	TITLE("title"),
	DATE("insertDatetime");

	private final String column;

	public static SortType of(String column) {
		for(SortType type : values()) {
			if(type.column.equals(column)) {
				return type;
			}
		}

		return DATE;
	}
}
