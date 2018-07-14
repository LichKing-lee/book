package com.yong.book.book.history;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {
	@Override
	List<History> findAll();
}
