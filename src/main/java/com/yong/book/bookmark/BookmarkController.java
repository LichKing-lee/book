package com.yong.book.bookmark;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yong.book.bookmark.dto.BookmarkDto;
import com.yong.book.bookmark.dto.BookmarkDtoCollector;
import com.yong.book.bookmark.dto.BookmarksDto;
import com.yong.book.login.LoginUserDetails;
import com.yong.book.member.Member;
import com.yong.book.member.MemberService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
	private BookmarkService bookmarkService;
	private MemberService memberService;

	public BookmarkController(BookmarkService bookmarkService, MemberService memberService) {
		this.bookmarkService = bookmarkService;
		this.memberService = memberService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void add(@AuthenticationPrincipal LoginUserDetails loginUserDetails, @RequestBody String bookName){
		Member member = memberService.getMember(loginUserDetails.getUsername());
		bookmarkService.add(new Bookmark(member, bookName));
	}

	@GetMapping
	public BookmarksDto get(@AuthenticationPrincipal LoginUserDetails loginUserDetails){
		List<Bookmark> bookmarks = bookmarkService.get(loginUserDetails.getId());

		return bookmarks.stream()
			.map(BookmarkDto::from)
			.collect(new BookmarkDtoCollector());
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void remove(@AuthenticationPrincipal LoginUserDetails loginUserDetails, @RequestBody Long id){
		bookmarkService.remove(loginUserDetails.getId(), id);
	}
}
