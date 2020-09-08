package guestbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.cmd.Command;

//Annotaion �ּ� (�ʱ� webServlet �Ӽ�): 1)url 2)�� ���°� ���ÿ� ������ �Ķ����
@WebServlet(urlPatterns="/guestbook/Controller",
initParams={@WebInitParam(name="mapping",value="/WEB-INF/cmd.properties")})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties cmds;
       
    public Controller() {
        super();
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {//ServletConfig: �����̳ʷκ��� ���� �� �������̼ǿ� ���� ������ ��´�
		// TODO Auto-generated method stub
		super.init(config);
		String path = config.getInitParameter("mapping");//�̸��� mapping�� �ʱ�ȭ �Ķ������ ���� ����(������ ����)
		InputStream is = getServletContext().getResourceAsStream(path);//path�� �ڿ�(������)�� ���� �� �ִ� stream ����
		cmds = new Properties();
		try {
			cmds.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");//properties���� ���� ��ɾ  ����
		String className = cmds.getProperty(cmd);//className ����
		try {
			Command command = (Command) Class.forName(className).newInstance();//�� �̸����� value�� �����Ͽ� ��ü�� ����
			command.execute(request,response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
