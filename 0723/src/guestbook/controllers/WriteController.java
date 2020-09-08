package guestbook.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

@WebServlet("/guestbook/write")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ServiceImpl();
		String result = "/web0722/guestbook";//db로부터 담아서 실행시켜야 되기 때문
		String writer = request.getParameter("writer");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		Article a = new Article(0,writer,pwd,null,content);
		service.addArticle(a);
		response.sendRedirect(result);//새로고침할 때 글 새로 생기는 것 없애기 위해
//		RequestDispatcher rd = request.getRequestDispatcher(result);
//		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
