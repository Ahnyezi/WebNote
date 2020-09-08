package guestbook.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

@WebServlet("/guestbook/Del")
public class DelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		String result = "/web0722/guestbook";//list controller로 보냄. db로부터 담아서 실행시켜야 되기 때문
		int num = Integer.parseInt(request.getParameter("num"));
		Article a = new Article(num,null,null,null,null);
		service.delArticle(num);
		response.sendRedirect(result);//새로고침할 때 글 새로 생기는 것 없애기 위해
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
