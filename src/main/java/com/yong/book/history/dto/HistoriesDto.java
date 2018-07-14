package com.yong.book.history.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoriesDto {
	List<HistoryDto> histories;
}
