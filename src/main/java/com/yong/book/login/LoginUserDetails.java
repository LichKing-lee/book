package com.yong.book.login;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.yong.book.member.Member;
import lombok.Getter;

@Getter
public class LoginUserDetails extends User {
	private Long id;

	public LoginUserDetails(Member member) {
		super(member.getMemberId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().name()));

		this.id = member.getId();
	}
}
