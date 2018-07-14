package com.yong.book.book.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.yong.book.book.api.response.BookResponse;

@Repository
@ConfigurationProperties(prefix = "openapi.kakao")
public class KakaoApiRepository implements BookApiRepository<BookResponse> {
	private ApiConfig apiConfig;
	private RestTemplate restTemplate;
	private HttpEntity<String> httpEntity;

	public KakaoApiRepository() {
		restTemplate = new RestTemplate();
	}

	// properties가 주입될때 api call header 세팅
	public void setApiConfig(ApiConfig apiConfig) {
		this.apiConfig = apiConfig;
		setHttpHeader(apiConfig);
	}

	private void setHttpHeader(ApiConfig apiConfig) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", apiConfig.getKey());

		httpEntity = new HttpEntity<>(httpHeaders);
	}

	public BookResponse call(ApiRequest request) {
		String fullUrl = apiConfig.getUrl() + "?" + request.toQueryString();
		return restTemplate.exchange(fullUrl, HttpMethod.GET, httpEntity, BookResponse.class).getBody();
	}
}
