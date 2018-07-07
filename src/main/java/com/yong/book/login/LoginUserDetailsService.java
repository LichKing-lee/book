package com.yong.book.login;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yong.book.member.Member;
import com.yong.book.member.MemberService;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	private MemberService memberService;

	public LoginUserDetailsService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		Optional<Member> member = memberService.getMemberAsOptional(memberId);

		return new LoginUserDetails(member.orElseThrow(() -> new UsernameNotFoundException("not found memberId :: " + memberId)));
	}
}
