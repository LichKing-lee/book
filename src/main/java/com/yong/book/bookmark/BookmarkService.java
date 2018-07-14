package com.yong.book.bookmark;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yong.book.common.request.Request;

@Service
public class BookmarkService {
	private BookmarkRepository bookmarkRepository;

	public BookmarkService(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}

	public void add(Bookmark bookmark) {
		bookmarkRepository.save(bookmark);
	}

	public List<Bookmark> get(Long id, Request request) {
		return bookmarkRepository.findAllByMemberId(id, createPageRequest(request))
			.stream().collect(toList());
	}

	public void remove(Long memberId, Long bookmakrId) {
		Bookmark bookmark = bookmarkRepository.findByMemberIdAndId(memberId, bookmakrId);
		bookmark.remove();
		bookmarkRepository.save(bookmark);
	}

	private Pageable createPageRequest(Request request) {
		return PageRequest.of(request.getPage(), 5, request.getDirection(), request.getSortColumn());
	}
}
