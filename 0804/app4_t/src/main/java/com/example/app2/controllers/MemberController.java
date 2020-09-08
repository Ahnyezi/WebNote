package com.example.app2.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.join.Shop_MemberService;

@Controller
public class MemberController {
	@Autowired
	private Shop_MemberService service;
	
	@GetMapping("/member")
	public String form(){
		return "member/form";
	}
	
	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam("id") String id, Model m){
		System.out.println("id:"+id);
		Shop_Member a = service.getMember(id);
		boolean flag = false;
		try{
			a.getPwd();
		}catch (EntityNotFoundException e){
			flag=true;
		}
		m.addAttribute("flag", flag);
		return "member/idcheck";
	}
}
