package com.yong.book.bookmark;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends PagingAndSortingRepository<Bookmark, Long> {
	Page<Bookmark> findAllByMemberId(Long id, Pageable pageable);
	Bookmark findByMemberIdAndId(Long id, Long bookmarkId);
}
