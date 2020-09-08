package com.example.app2.model.order;

import org.springframework.data.jpa.repository.JpaRepository;
//Dao(interface)
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
	//반환타입 findBy컬럼명();
	//반환타입 findBy컬럼명like();
}
