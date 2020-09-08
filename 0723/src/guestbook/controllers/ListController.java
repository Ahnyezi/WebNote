package guestbook.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

@WebServlet("/guestbook")
//첫 페이지: db로부터 글목록을 가져와서 페이지로 출력한다.
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		String result = "/guestbook/list.jsp";
		ArrayList<Article> list = service.getAll();
		//request에 객체를 담는다. 데이터 가지고 페이지 이동을 위해서
		request.setAttribute("list", list);//request객체에 list 저장 (이와 같이 데이터를 유지하여 전달할 때에는 sendredirect 방식 사용하면 안됨.)
		RequestDispatcher rd = request.getRequestDispatcher(result);
		rd.forward(request, response);//forward방식으로  페이지 이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
