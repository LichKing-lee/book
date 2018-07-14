package com.yong.book.book.api.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yong.book.book.api.json.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Document {
	private String title;
	private String contents;
	private String url;
	private String isbn;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime datetime;
	private List<String> authors;
	private String publisher;
	private List<String> translators;
	private int price;
	@JsonProperty("sale_price")
	private int salePrice;
	@JsonProperty("sale_yn")
	private String saleYn;
	private String category;
	private String thumbnail;
	private String barcode;
	@JsonProperty("ebook_barcode")
	private String ebookBarcode;
	private String status;
}
