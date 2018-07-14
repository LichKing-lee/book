package com.yong.book.history.dto;

import java.time.LocalDateTime;

import com.yong.book.history.History;
import lombok.Getter;

@Getter
public class HistoryDto {
	private String title;
	private LocalDateTime selectedDatetime;

	public static HistoryDto from(History history) {
		// FIXME History에서 dto를 만드는것보다는 dto에서 history를 만드는게 낫다고 판단
		HistoryDto dto = new HistoryDto();
		dto.title = history.getTitle();
		dto.selectedDatetime = history.getInsertDatetime();
		return dto;
	}
}
