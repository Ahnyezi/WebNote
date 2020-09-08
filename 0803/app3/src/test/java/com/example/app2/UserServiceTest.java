package com.example.app2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app3.App2Application;
import com.example.app3.model.join.UserService;
import com.example.app3.model.join.Usertb;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App2Application.class)
public class UserServiceTest {

	@Autowired
	private UserService service;
	
	@Test
	public void testAddUser(){
		service.addUser(new Usertb("uiop","uiop","uiop","uiop"));
	}
	
}
