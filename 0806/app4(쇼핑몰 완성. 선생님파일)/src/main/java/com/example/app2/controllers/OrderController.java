package com.example.app2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app2.model.order.MyOrder;
import com.example.app2.model.order.MyOrderService;

@Controller
public class OrderController {
	@Autowired
	private MyOrderService service;

	@GetMapping("/order")
	public String form() {
		return "order/form";
	}

	@PostMapping("/order")
	public String order(MyOrder o) {
		service.addOrder(o);
		System.out.println(o.getCon_id().getOrders());
		return "redirect:/order/mylist/" + o.getCon_id().getId() + "/" + o.getType();
	}
}
