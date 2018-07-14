package com.yong.book.bookmark.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookmarksDto {
	private List<BookmarkDto> bookmarks;
}
