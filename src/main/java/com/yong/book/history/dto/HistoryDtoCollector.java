package com.yong.book.history.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class HistoryDtoCollector implements Collector<HistoryDto, List<HistoryDto>, HistoriesDto> {
	@Override
	public Supplier<List<HistoryDto>> supplier() {
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<HistoryDto>, HistoryDto> accumulator() {
		return List::add;
	}

	@Override
	public BinaryOperator<List<HistoryDto>> combiner() {
		return (list1, list2) -> {
			List<HistoryDto> result = new ArrayList<>(list1);
			result.addAll(list2);
			return result;
		};
	}

	@Override
	public Function<List<HistoryDto>, HistoriesDto> finisher() {
		return HistoriesDto::new;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.singleton(Characteristics.UNORDERED);
	}
}
