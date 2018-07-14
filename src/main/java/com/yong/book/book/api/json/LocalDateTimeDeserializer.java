package com.yong.book.book.api.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws
		IOException,
		JsonProcessingException {
		return LocalDateTime.parse(p.getText(), DATE_TIME_FORMATTER);
	}
}
