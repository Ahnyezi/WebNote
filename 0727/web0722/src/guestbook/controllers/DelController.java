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
		String result = "/web0722/guestbook";//list controller�� ����. db�κ��� ��Ƽ� ������Ѿ� �Ǳ� ����
		int num = Integer.parseInt(request.getParameter("num"));
		Article a = new Article(num,null,null,null,null);
		service.delArticle(num);
		response.sendRedirect(result);//���ΰ�ħ�� �� �� ���� ����� �� ���ֱ� ����
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
