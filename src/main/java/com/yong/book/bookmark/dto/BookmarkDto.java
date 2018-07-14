package com.yong.book.bookmark.dto;

import com.yong.book.bookmark.Bookmark;
import lombok.Data;
import lombok.Getter;

@Getter
public class BookmarkDto {
	private String bookName;

	public static BookmarkDto from(Bookmark bookmark) {
		BookmarkDto dto = new BookmarkDto();
		dto.bookName = bookmark.getBookName();

		return dto;
	}
}
