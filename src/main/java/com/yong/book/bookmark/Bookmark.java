package com.yong.book.bookmark;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yong.book.member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted = false")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "book_name", nullable = false)
	private String bookName;
	@Column(nullable = false)
	private boolean deleted;
	@ManyToOne
	@JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
	private Member member;
	@CreatedDate
	@Column(name = "insert_datetime", updatable = false, nullable = false)
	private LocalDateTime insertDatetime;
	@LastModifiedDate
	@Column(name = "update_datetime")
	private LocalDateTime updateDatetime;

	public Bookmark(Member member, String bookName) {
		this.member = member;
		this.bookName = bookName;
	}

	public void remove() {
		this.deleted = true;
	}
}
