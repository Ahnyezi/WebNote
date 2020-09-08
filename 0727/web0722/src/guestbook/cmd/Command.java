package guestbook.cmd;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {//�߻�Ŭ����: �߻� �޼��带 1�� �̻� ���� Ŭ����
	protected HttpServletRequest req;
	protected HttpServletResponse res;//protected:�ڽ� Ŭ�������� ����� �� �ְ�.

	//��û ���� �߻� �޼���::��û ������ ���� ���� ����� �޶���  ex.�߰�/����/����..
	public abstract void execute(HttpServletRequest req, HttpServletResponse res);
	
	//������ �̵� �޼���1: forward
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
	//������ �̵� �޼���2: redirect
	public void redirect(String url){
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
