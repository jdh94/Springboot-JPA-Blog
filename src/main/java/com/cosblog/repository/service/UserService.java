package com.cosblog.repository.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosblog.model.RoleType;
import com.cosblog.model.User;
import com.cosblog.repository.UserRepository;

import ch.qos.logback.core.encoder.Encoder;

//스프링이 컴포넌트 스캔을 통해서  Bean에 등록해줌. IoC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional(readOnly=true)
	public User 회원찾기(String username) {
		User user =  userRepository.findByUsername(username).get();
		return null;
	}

	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); // 1234 원문
		String encPassword = encoder.encode(rawPassword); // 해쉬
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional
	public void 회원수정(User user) {
		// 수정시에서는 영속성 컨텍스트 유저 오브젝트를 영속화 시키고, 영속화된 User오브젝트를 수정
		// select를 통해 User오브텍트를 DB로 가져와 영속화 시키고
		// 영속화된 오브젝트를 변경하여 자동으로 DB에 update문을 날려주는 형태로 수정
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		// 회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit이 자동으로 이루어짐
		// 영속화된 persistance 객체가 변화가 감지되면 더티체킹이 되어 update문을 날려줌.
	}
	
	
	
}
