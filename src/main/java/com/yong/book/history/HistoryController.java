package com.yong.book.history;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yong.book.history.dto.HistoriesDto;
import com.yong.book.history.dto.HistoryDto;
import com.yong.book.history.dto.HistoryDtoCollector;
import com.yong.book.common.request.Request;
import com.yong.book.login.LoginUserDetails;

@RestController
public class HistoryController {
	private HistoryService historyService;

	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}

	@RequestMapping("/history")
	public HistoriesDto get(@AuthenticationPrincipal LoginUserDetails loginUserDetails, Request request) {
		List<History> histories = historyService.getHistories(loginUserDetails.getId(), request);

		// List<History>로 리턴해도되지만 추후 API 확장성을 위해 List를 쥐고있는 DTO 이용
		return histories.stream()
			.map(HistoryDto::from)
			.collect(new HistoryDtoCollector());
	}
}
