package com.yong.book.book.api.response;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookResponse {
	private Meta meta;
	private List<Document> documents;
}
