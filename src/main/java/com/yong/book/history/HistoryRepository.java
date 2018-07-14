package com.yong.book.history;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {
	List<History> findByMemberId(Long id);
}
