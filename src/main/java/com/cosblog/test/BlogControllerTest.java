package com.cosblog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.cos.blog패키지 이하의
// 파일 중 특정 어노테이션이 붙어있는 클래스 파일들을 new해서 ioc스프링
// 컨테이너에 관리해줌
@Controller
public class BlogControllerTest {
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String hello() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resource/static
		//리턴명 : /home.html
		//풀경로 : src/main/resources/static/home.html
		return "home";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/mypic.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		//prefix : /WEB-INF/views/
		//suffix : jsp
		//풀네임 : /WEB-INF/views/test.jsp
		return "test";
	}
}
