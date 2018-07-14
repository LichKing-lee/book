package com.yong.book.member;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "member_id", nullable = false, unique = true)
	private String memberId;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleType role;
}
