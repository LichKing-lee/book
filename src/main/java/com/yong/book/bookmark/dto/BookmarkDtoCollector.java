package com.yong.book.bookmark.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class BookmarkDtoCollector implements Collector<BookmarkDto, List<BookmarkDto>, BookmarksDto> {
	@Override
	public Supplier<List<BookmarkDto>> supplier() {
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<BookmarkDto>, BookmarkDto> accumulator() {
		return List::add;
	}

	@Override
	public BinaryOperator<List<BookmarkDto>> combiner() {
		return (list1, list2) -> {
			List<BookmarkDto> result = new ArrayList<>(list1);
			result.addAll(list2);

			return result;
		};
	}

	@Override
	public Function<List<BookmarkDto>, BookmarksDto> finisher() {
		return BookmarksDto::new;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.singleton(Characteristics.UNORDERED);
	}
}
