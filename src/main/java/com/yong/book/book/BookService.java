package com.yong.book.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yong.book.book.api.KakaoApiRepository;
import com.yong.book.book.api.request.BookRequest;
import com.yong.book.book.api.response.BookResponse;
import com.yong.book.book.api.response.Document;
import com.yong.book.book.exception.BookNotFoundException;
import com.yong.book.history.History;
import com.yong.book.history.HistoryRepository;
import com.yong.book.member.Member;
import com.yong.book.member.MemberService;

@Service
public class BookService {
	private KakaoApiRepository kakaoApiRepository;
	private HistoryRepository historyRepository;
	private MemberService memberService;

	public BookService(KakaoApiRepository kakaoApiRepository,
		HistoryRepository historyRepository,
		MemberService memberService) {
		this.kakaoApiRepository = kakaoApiRepository;
		this.historyRepository = historyRepository;
		this.memberService = memberService;
	}

	@Transactional
	public BookResponse searchAndHistory(BookRequest bookRequest, String memberId) {
		BookResponse bookResponse = kakaoApiRepository.call(bookRequest);

		if(bookResponse == null) {
			throw new BookNotFoundException(bookRequest.toString());
		}

		Member member = memberService.getMember(memberId);
		bookResponse.getDocuments()
			.stream()
			.map(Document::getTitle)
			.map(title -> new History(title, member))
			.forEach(historyRepository::save);

		return bookResponse;
	}
}
