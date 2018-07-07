package com.yong.book.book.api;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
	private String title;
	private String contents;
	private String url;
	private String isbn;
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
