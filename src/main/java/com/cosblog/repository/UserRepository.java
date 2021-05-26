package com.cosblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosblog.madel.User;

//DAO
//DI 자동으로 bean등록이 된다.
//@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
	// JPA Naming 쿼리
	User findByUsernameAndPassword(String username, String password);
	
}
