package cmd.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.Service;
import board.ServiceImpl;
import cmd.Command;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		int num = Integer.parseInt(req.getParameter("num"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Board b = new Board(num, null, title, null, content);
		Service service = new ServiceImpl();
		service.editBoard(b);
		redirect(req.getContextPath() + "/BoardController?cmd=list");
	}

}
