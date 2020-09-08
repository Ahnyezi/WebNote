package com.example.springApp1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springApp1.model.join.Member;
import com.example.springApp1.model.join.MemberService;

@Controller
public class TestController {
//요청 url 별로 실행할 코드 작성
	
	//의존성 자동 주입: 타입이나 이름이 동일한 bean을 찾아서 넣어줌
	@Autowired
	private MemberService service;
	
	@RequestMapping("/")
	public String home(){	//@GetMapping("/edit") @PostMapping("/edit") 
		return "index";		//String: 뷰 페이지 경로 (view/index.jsp)
	}
	
	//get방식으로 '/edit' 받는 경우
	@GetMapping("/edit")
	public void editForm(){//반환값이 없는 경우: url과 동일한 이름의 view page로 간다
		
	}
	//post방식으로 '/edit' 받는 경우
	@PostMapping("/edit")
	public String edit(@ModelAttribute("m") Member m){
		return "editResult";
	}
	
	// "/list" 받는 경우
	@RequestMapping("/list")
	public ModelAndView list(){//ModelAndView: 모델과 뷰 넣을수 있는 객체
		//뷰 페이지 경로 setting(1: 생성자 param에 viewpage 이름 넣기, 2:mav.setViewName("viewpagename"));
		ModelAndView mav = new ModelAndView("list");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		mav.addObject("list",list);//(전달할 데이터 이름, 값)
		return mav;
	}
	
	// "/member/list" 받는 경우
	@GetMapping("/member/list")
	public ModelAndView modelList(){
		ModelAndView mav = new ModelAndView("list2");//list2라는 이름의 viewpage 생성자에 설정

		ArrayList<Member> list = service.getMembers();
		mav.addObject("m",list);//m이라는 이름으로 list를 참조할 수 있게 전송한다.
		return mav;
	}
	
	
	


}
