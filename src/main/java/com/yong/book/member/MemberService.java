package com.yong.book.member;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Optional<Member> getMemberAsOptional(String memberId) {
		// TODO repository에서부터 Optional 되는지 확인
		return Optional.ofNullable(memberRepository.findByMemberId(memberId));
	}
}
