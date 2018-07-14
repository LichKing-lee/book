package com.yong.book.bookmark.dto;

import com.yong.book.bookmark.Bookmark;
import lombok.Getter;

@Getter
public class BookmarkDto {
	private String title;

	public static BookmarkDto from(Bookmark bookmark) {
		BookmarkDto dto = new BookmarkDto();
		dto.title = bookmark.getTitle();

		return dto;
	}
}
