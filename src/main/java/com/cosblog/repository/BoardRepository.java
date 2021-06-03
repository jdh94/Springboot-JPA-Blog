package com.cosblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosblog.model.Board;
import com.cosblog.model.User;

//DAO
//DI 자동으로 bean등록이 된다.
//@Repository // 생략가능
public interface BoardRepository extends JpaRepository<Board, Integer> {
		
}

// JPA Naming 쿼리
// User findByUsernameAndPassword(String username, String password);

