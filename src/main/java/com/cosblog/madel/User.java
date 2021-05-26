package com.cosblog.madel;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java를 테이블로 매핑해주는 기술
@Entity  // User 클래스가 MySQL에 태이블이 생성이 된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DynamicInsert // insert시 null인 빌드 제외
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment

	@Column(nullable = false, length = 30, unique = true)
	private String username; // 아이디

	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email; // myEmail, my_email

	//@ColumnDefault("user")
	//DB는 RoleType이 없음
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. // admin, user, manager
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createData;
}
