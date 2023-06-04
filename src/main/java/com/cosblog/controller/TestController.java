package com.cosblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {
	
	@Autowired
	private TestService TestService;
 
	//	@AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {

		model.addAttribute("testPage", TestService.글목록(pageable));
//		model.addAttribute("boards", boardService.글목록(pageable));
		// yml설정값 prefix : "/WEB-INF/views/" + return 값 "index" + yml설정값 suffix : ".jsp" 의 경로를 찾아줌
		// GetMapping의 "/"를 통해 설정되있는 포트값 주소의 + "/"인 url으로 매핑
		System.out.println("test page call");
		return "testPage";
	}

}
