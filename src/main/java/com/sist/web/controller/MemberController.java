package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.MemberVO;

/*
	 git pull origin main
	 git checkout -b develop
	 git add .
	 git commit -m ""
	 git push
	 -----------------------
	 git pull origin develop
	 git checkout -b feature/기능명
	 git add .
	 git commit -m ""
	 git push
	 
	 main : 배포용
	  |
	 develop : 개발 통함
	  |
	 -------
	 |  |  |
	 기능 분기점
	 
	 개발 후 commit, pull requeset => develop
	------------------------------------------
	pull request 명령어
	1. gh pr create --base develop --head feature/login
	   --title "" --body ""
	   
	2. gh pr merge
 */

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberMapper mMapper;
	
	@GetMapping("/list")
	public String member_list(Model model) {
		List<MemberVO> list=mMapper.memberListData();
		for(MemberVO vo: list) {
			System.out.println(vo.getId()+" "+vo.getName()+ " "+ vo.getSex());
		}
		model.addAttribute("list",list);
		return "list";
	}
}
