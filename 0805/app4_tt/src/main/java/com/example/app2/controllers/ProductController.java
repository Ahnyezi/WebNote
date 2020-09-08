package com.example.app2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String add(ProductFile pf){
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		return "redirect:/product/listbyseller/"+seller;
	}

	@GetMapping("/product/details/{num}")
	public String details(@PathVariable("num") int num, Model m) {
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		return "product/details";
	}
	
}
