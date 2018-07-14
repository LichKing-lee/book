package com.yong.book.common.request;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Request {
	private int page;
	private String sort;
	private String direction;

	private SortType asSortType() {
		return SortType.of(sort);
	}

	public String getSortColumn() {
		return asSortType().getColumn();
	}

	public Sort.Direction getDirection() {
		return Sort.Direction.ASC.name().equalsIgnoreCase(direction) ? Sort.Direction.ASC : Sort.Direction.DESC;
	}
}
