package com.yong.book.bookmark;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
	private BookmarkRepository bookmarkRepository;

	public BookmarkService(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}

	public void add(Bookmark bookmark) {
		bookmarkRepository.save(bookmark);
	}

	public List<Bookmark> get(Long id) {
		return bookmarkRepository.findAllByMemberId(id);
	}

	public void remove(Long memberId, Long bookmakrId) {
		Bookmark bookmark = bookmarkRepository.findByMemberIdAndId(memberId, bookmakrId);
		bookmark.remove();
		bookmarkRepository.save(bookmark);
	}
}
