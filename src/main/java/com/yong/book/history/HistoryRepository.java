package com.yong.book.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HistoryRepository extends PagingAndSortingRepository<History, Long> {
	Page<History> findByMemberId(Long id, Pageable pageable);
}
