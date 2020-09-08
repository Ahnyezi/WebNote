package com.example.springApp1;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springApp1.model.board.Board;
import com.example.springApp1.model.board.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("board/list");
		ArrayList<Board> list =service.select();
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/board/write")
	public void writeForm(){
		
	}
	
	@PostMapping("/board/write")
	public String write(Board b){
		service.insert(b);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView detail(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("board/detail");
		int num = Integer.parseInt(req.getParameter("num"));
		Board b = service.selectById(num);
		mav.addObject("b",b);
		return mav;
	}
	
	@RequestMapping("/board/edit")
	public String edit(HttpServletRequest req, Board b){
		service.update(b);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/del")
	public String del(HttpServletRequest req){
		int num = Integer.parseInt(req.getParameter("num"));
		service.delete(num);
		return "redirect:/board/list";
	}
}
