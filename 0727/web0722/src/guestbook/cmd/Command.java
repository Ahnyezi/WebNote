package guestbook.cmd;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {//추상클래스: 추상 메서드를 1개 이상 가진 클래스
	protected HttpServletRequest req;
	protected HttpServletResponse res;//protected:자식 클래스들이 사용할 수 있게.

	//요청 실행 추상 메서드::요청 종류에 따라 구현 방식이 달라짐  ex.추가/수정/삭제..
	public abstract void execute(HttpServletRequest req, HttpServletResponse res);
	
	//페이지 이동 메서드1: forward
	public void forward(String url){
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try {
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//페이지 이동 메서드2: redirect
	public void redirect(String url){
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
