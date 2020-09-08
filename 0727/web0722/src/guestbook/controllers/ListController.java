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
//ù ������: db�κ��� �۸���� �����ͼ� �������� ����Ѵ�.
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
		//request�� ��ü�� ��´�. ������ ������ ������ �̵��� ���ؼ�
		request.setAttribute("list", list);//request��ü�� list ���� (�̿� ���� �����͸� �����Ͽ� ������ ������ sendredirect ��� ����ϸ� �ȵ�.)
		RequestDispatcher rd = request.getRequestDispatcher(result);
		rd.forward(request, response);//forward�������  ������ �̵�
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
