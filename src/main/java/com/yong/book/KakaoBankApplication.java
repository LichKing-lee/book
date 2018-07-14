package com.yong.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;

@EnableJpaAuditing
@EntityScan(basePackageClasses = Jsr310JpaConverters.class, basePackages = "com.yong.book")
@SpringBootApplication
@EnableConfigurationProperties
public class KakaoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaoBankApplication.class, args);
	}
}
