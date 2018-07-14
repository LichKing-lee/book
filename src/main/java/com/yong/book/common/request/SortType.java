package com.yong.book.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
	TITLE("title"),
	DATE("insert_datetime");

	private final String column;

	public static SortType of(String pivot) {
		for(SortType type : values()) {
			if(type.column.equals(pivot)) {
				return type;
			}
		}

		return DATE;
	}
}
