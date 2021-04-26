package com.cosblog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.cos.blog패키지 이하의
// 파일 중 특정 어노테이션이 붙어있는 클래스 파일들을 new해서 ioc스프링
// 컨테이너에 관리해줌
@RestController 
public class BlogControllerTest {

	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot</h1>";
	}
}
