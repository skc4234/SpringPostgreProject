package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.MemberVO;
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
