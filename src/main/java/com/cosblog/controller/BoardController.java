package com.cosblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index() {
		// yml설정값 prefix : "/WEB-INF/views/" + return 값 "index" + yml설정값 suffix : ".jsp" 의 경로를 찾아줌
		// GetMapping의 "/"를 통해 설정되있는 포트값 주소의 + "/"인 url으로 매핑
	
		return "index";
	}
}
