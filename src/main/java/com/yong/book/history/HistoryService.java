package com.yong.book.history;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HistoryService {
	private HistoryRepository historyRepository;

	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	public List<History> getHistories(Long memberId) {
		List<History> histories = historyRepository.findByMemberId(memberId);

		// 최신순부터 보여주기위해 역순(revresed)으로 정렬
		return histories.stream()
			.sorted(Comparator.comparing(History::getInsertDatetime).reversed())
			.collect(toList());
	}
}
