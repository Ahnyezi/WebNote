package com.example.app2.model.join;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shop_MemberService {
	
	@Autowired
	private Shop_Member_Repos rep;
	
	public void saveMember(Shop_Member sm){
		rep.save(sm);
	}
	
	public Shop_Member getMember(String id){
		return rep.getOne(id);
	}
	
	public void delMember(String id){
		rep.deleteById(id);
	}
}
