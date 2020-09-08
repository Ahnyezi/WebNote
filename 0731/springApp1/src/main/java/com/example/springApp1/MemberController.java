package com.example.springApp1;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/member/login")
	public void loginForm(){
		
	}
	
	@PostMapping("/member/login")
	public String login(HttpServletRequest req, @RequestParam("id") String id,@RequestParam("pwd") String pwd,
			Map<String,Boolean> map){//입력 양식 이름이 id인 값 가져와서 String id에 담겠다.
		Member m = service.getMember(id);
		HttpSession session = req.getSession();
		String result = "";
		if(m!=null && pwd.equals(m.getPwd())){
			session.setAttribute("id", id);
			result = "redirect:/member/result";
			map.put("result", true);
		}else{
			result="redirect:/member/login";
			map.put("result", false);
		}
		return result;
	}
	
	@GetMapping("member/edit")
	public void editForm(HttpServletRequest req,Map<String,Member> map){
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		map.put("m", m);
	}
	
	@PostMapping("member/edit")//
	public String edit(Member m){
		System.out.println("m 값:"+m);
		service.editMember(m);
		return "redirect:/member/result";
	}
	
	@RequestMapping("member/result")///////
	public void result(){}
	
	@RequestMapping("member/logout")
	public String logout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@RequestMapping("member/out")//
	public String out(HttpServletRequest req){
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		return "redirect:/member/logout";
	}
}

