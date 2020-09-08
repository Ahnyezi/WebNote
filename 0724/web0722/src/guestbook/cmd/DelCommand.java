package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class DelCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.req = req;
		this.res = res;
		Service service = new ServiceImpl();
		int num = Integer.parseInt(req.getParameter("num"));
		service.delArticle(num);
		redirect("Controller?cmd=list");//새로고침할 때 글 새로 생기는 것 없애기 위해
	}

}
