package com.example.app2.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.join.MemberType;
import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.join.Shop_MemberService;
import com.example.app2.model.product.Product;

@Controller
public class MemberController {
	@Autowired
	private Shop_MemberService service;

	@GetMapping("/member")
	public String form() {
		return "member/form";
	}

	@PostMapping("/member")
	public String join(Shop_Member sm) {
		service.saveMember(sm);
		return "redirect:/member/login";
	}

	@GetMapping("/member/login")
	public void loginForm() {
	}

	@PostMapping("/member/login")
	public String login(Shop_Member sm, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Shop_Member a = service.getMember(sm.getId());
		boolean flag = false;
		String pwd = "";
		try {
			pwd = a.getPwd();
			if (pwd.equals(sm.getPwd())) {
				flag = true;
				System.out.println("로그인성공");
			} else {
				System.out.println("패스워드 불일치");
			}
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");
		}
		String result = "redirect:/member/login";
		if (flag) {
			session.setAttribute("id", sm.getId());
			if (a.getType() == MemberType.CONSUMER) {
				result = "redirect:/product/list";
			} else if (a.getType() == MemberType.SELLER) {
				result = "redirect:/product/listbyseller/" + sm.getId();
			}
		}
		return result;
	}

	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/login";
	}

	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam("id") String id, Model m) {
		Shop_Member a = service.getMember(id);
		boolean flag = false;
		try {
			a.getPwd();
		} catch (EntityNotFoundException e) {
			flag = true;
		}
		m.addAttribute("flag", flag);
		return "member/idcheck";
	}
	
	@GetMapping("/product/listbyseller/{seller}")
	public String listbyseller(@PathVariable("seller") String seller, Model m){
		Shop_Member sm = service.getMember(seller);
		List<Product> list = sm.getProducts();
		m.addAttribute("list", list);
		return "product/list";
	}
}
