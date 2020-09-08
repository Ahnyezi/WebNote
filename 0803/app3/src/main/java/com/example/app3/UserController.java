package com.example.app3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app3.model.join.UserService;
import com.example.app3.model.join.Usertb;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/user/join")
	public String joinForm(){
		return "/user/join";
	}
	
	@PostMapping("/user/join")
	public String join(Usertb u){
		service.addUser(u);
		return "redirect:/user";
	}
	
	@GetMapping("/user")
	public String userList(Model m){
		List<Usertb> list = service.getUsers();
		System.out.println("list:"+list);
		m.addAttribute("list",list);
		return "/user/list";
	}
	
	@GetMapping("/user/{id}")//검색시 검색할 값을 함께 보냄. ex./user/asdf
	public String editForm(@PathVariable("id") String id, Model m){
		Usertb u = service.getUser(id);
		m.addAttribute("u", u);
		return "user/edit";
	}
	
	@PostMapping("/user/edit")
	public String edit(Usertb u){
		service.editUser(u);
		return "redirect:/user";
	}
	
	@PostMapping("/user/delete")
	public String edit(@RequestParam("id") String id){
		service.delUser(id);
		return "redirect:/user";
	}
	
//	@GetMapping("/user/delete/{id}")
//	public String delForm(@PathVariable("id") String id){
//		service.delUser(id);
//		return "redirect:/user";
//	}
}
