package com.yong.book.book.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Repository
@ConfigurationProperties(prefix = "openapi.kakao")
@Setter
public class BookApiRepository {
	private ApiConfig apiConfig;

	public BookResponse call() {
		System.out.println(apiConfig.getUrl());
		return null;
	}
}
