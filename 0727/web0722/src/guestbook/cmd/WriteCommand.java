package guestbook.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class WriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		String writer = req.getParameter("writer");
		String pwd = req.getParameter("pwd");
		String content = req.getParameter("content");
		Article a = new Article(0,writer,pwd,null,content);
		service.addArticle(a);
		//redirect("/web0722/guestbook/Controller?cmd=list");
		redirect("Controller?cmd=list");
	}

}
