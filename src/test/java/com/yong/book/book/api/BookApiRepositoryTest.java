package com.yong.book.book.api;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApiRepositoryTest {
	@Autowired
	private BookApiRepository bookApiRepository;

	@Test
	public void call() {
		bookApiRepository.call();
	}
}