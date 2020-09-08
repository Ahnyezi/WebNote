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

/**
 * Servlet implementation class EditFormController
 */
@WebServlet("/guestbook/editForm")
public class EditFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "/guestbook/editForm.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		Service service = new ServiceImpl();
		Article a = service.getArticle(num);
		request.setAttribute("a",a);//request객체에 list 저장 (이와 같이 데이터를 유지하여 전달할 때에는 sendredirect 방식 사용하면 안됨.)
		RequestDispatcher rd = request.getRequestDispatcher(result);
		rd.forward(request, response);//forward방식으로  페이지 이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
