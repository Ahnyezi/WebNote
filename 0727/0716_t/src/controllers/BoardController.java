package controllers;

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

import cmd.Command;

@WebServlet(urlPatterns = "/BoardController", initParams = {
		@WebInitParam(name = "mapping", value = "/WEB-INF/cmdprop/boardcmd.properties") })

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties cmds;
       
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String path = config.getInitParameter("mapping");// 이름이 mapping인 초기화
		// 파라메터의 값을 읽음
		InputStream is = getServletContext().getResourceAsStream(path);
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
		String cmd = request.getParameter("cmd");
		
		if (cmd == null || cmd.equals("")) {
			cmd = "list";
		}

		String className = cmds.getProperty(cmd);
		System.out.println(className);
		try {

			Command command = (Command) Class.forName(className).newInstance();
			command.execute(request, response);
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
