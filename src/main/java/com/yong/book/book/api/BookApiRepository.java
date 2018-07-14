package com.yong.book.book.api;

public interface BookApiRepository<T> {
	T call(ApiRequest apiRequest);
}
