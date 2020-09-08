package cmd.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.Service;
import board.ServiceImpl;
import cmd.Command;

public class WriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Board b = new Board(0, writer, title, null, content);
		Service service = new ServiceImpl();
		service.addBoard(b);
		redirect(req.getContextPath() + "/BoardController?cmd=list");
	}

}
