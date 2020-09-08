package guestbook.cmd;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class EditFormCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		int num = Integer.parseInt(req.getParameter("num"));
		Article a = service.getArticle(num);
		req.setAttribute("a",a);//request∞¥√ºø° list ¿˙¿Â
		forward("/guestbook/editForm.jsp");
	}

}
