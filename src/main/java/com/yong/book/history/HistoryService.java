package com.yong.book.history;

import static java.util.stream.Collectors.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yong.book.common.request.Request;

@Service
public class HistoryService {
	private HistoryRepository historyRepository;

	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	public List<History> getHistories(Long memberId, Request request) {
		Page<History> histories = historyRepository.findByMemberId(memberId, createPageRequest(request));

		return histories.stream()
			.collect(toList());
	}

	private Pageable createPageRequest(Request request) {
		return PageRequest.of(request.getPage(), 5, request.getDirection(), request.getSortColumn());
	}
}
