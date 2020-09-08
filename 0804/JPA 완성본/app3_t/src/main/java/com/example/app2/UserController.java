package com.example.app2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.article.Article;
import com.example.app2.model.join.UserService;
import com.example.app2.model.join.Usertb;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/user/join")
	public String joinForm() {
		return "user/join";
	}

	@PostMapping("/user/join")
	public String join(Usertb u) {
		service.addUser(u);
		return "redirect:/user";
	}

	@GetMapping("/user")
	public String userList(Model m) {
		List<Usertb> list = service.getUsers();
		m.addAttribute("list", list);
		return "user/list";
	}

	@GetMapping("/user/{id}")
	public String editForm(@PathVariable("id") String id, Model m) {
		Usertb u = service.getUser(id);
		m.addAttribute("u", u);
		return "user/edit";
	}

	@PostMapping("/user/edit")
	public String edit(Usertb u) {
		service.editUser(u);
		return "redirect:/user";
	}

	@PostMapping("/user/delete")
	public String del(@RequestParam("id") String id) {
		service.delUser(id);
		return "redirect:/user";
	}

	@GetMapping("/article/listbywriter")
	public String listByWriter(@RequestParam("writer") String writer, Model m) {
		Usertb u = service.getUser(writer);
		List<Article> list = u.getArticles();
		m.addAttribute("list", list);
		return "article/list";
	}

}
