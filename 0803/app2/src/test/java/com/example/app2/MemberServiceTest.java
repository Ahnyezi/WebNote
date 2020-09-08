package com.example.app2;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app2.join.Member;
import com.example.app2.join.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
	@Autowired
	private MemberService service;
	
	@Test
	//테스트 할 메서드에 테스트 어노테이션 붙임
	public void testGetMember(){
		ArrayList<Member> list = service.getMembers();
		System.out.println(list);
	}
	
	@Test
	public void testAddMember(){
		service.addMember(new Member("qwer","qwer","qwer","qwer"));
	}
}
