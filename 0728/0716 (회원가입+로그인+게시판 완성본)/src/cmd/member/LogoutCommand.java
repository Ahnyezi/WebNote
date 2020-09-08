package cmd.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmd.Command;

public class LogoutCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		forward("/views/member/loginForm.jsp");
	}

}
