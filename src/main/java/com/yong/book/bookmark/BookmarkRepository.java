package com.yong.book.bookmark;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {
	List<Bookmark> findAllByMemberId(Long id);
	Bookmark findByMemberIdAndId(Long id, Long bookmarkId);
}
