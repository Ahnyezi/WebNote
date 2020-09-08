package com.example.app2.model.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {
	
	@Autowired
	private MyOrderRepository rep;
	
	public void addOrder(MyOrder o){
		rep.save(o);
	}
	
}
