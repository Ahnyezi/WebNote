package com.example.app2.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app2.model.join.MemberType;
import com.example.app2.model.product.Product;
import com.example.app2.model.product.ProductFile;
import com.example.app2.model.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/product")
	public String form() {
		return "product/form";
	}

	@PostMapping("/product")
	public String add(ProductFile pf) {
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		return "redirect:/product/listbyseller/" + seller;
	}

	@GetMapping("/product/details/{num}")
	public String details(HttpServletRequest req, @PathVariable("num") int num, Model m) {
		String result = "";
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		HttpSession session = req.getSession(false);
		MemberType mt = (MemberType) session.getAttribute("type");
		System.out.println(mt);
		if (mt == MemberType.CONSUMER) {
			result = "order/details";
		} else if (mt == MemberType.SELLER) {
			result = "product/details";
		}
		return result;
	}

	@GetMapping("/order/prod_list")
	public String listall(Model m) {
		List<Product> list = service.getAll();
		m.addAttribute("list", list);
		return "order/prod_list";
	}

	@GetMapping("/order/prod_list/{name}")
	public String listbyname(@PathVariable("name") String name, Model m) {
		List<Product> list = service.getByName("%" + name + "%");
		m.addAttribute("list", list);
		return "order/prod_list";
	}

	@PostMapping("/product/edit")
	public String edit(Product p) {
		service.editProduct(p);
		return "redirect:/product/listbyseller/" + p.getSeller().getId();
	}

	@GetMapping("/product/{num}/del")
	public String del(@PathVariable("num") int num, HttpServletRequest req) {
		service.delProduct(num);
		HttpSession session = req.getSession(false);
		String seller = (String) session.getAttribute("id");
		return "redirect:/product/listbyseller/" + seller;
	}
}
