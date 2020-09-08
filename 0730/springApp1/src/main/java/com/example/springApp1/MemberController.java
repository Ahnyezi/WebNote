package com.example.springApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springApp1.model.join.Member;
import com.example.springApp1.model.join.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/join")
	public void joinForm(){
		
	}
	
	@PostMapping("/member/join")
	public String join(Member m){
		service.addMember(m);
		return "redirect:/member/list";
	}

}
