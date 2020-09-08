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

//Annotaion 주석 (초기 webServlet 속성): 1)url 2)웹 오픈과 동시에 가져올 파라미터
@WebServlet(urlPatterns="/guestbook/Controller",
initParams={@WebInitParam(name="mapping",value="/WEB-INF/cmd.properties")})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties cmds;
       
    public Controller() {
        super();
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {//ServletConfig: 컨테이너로부터 현재 웹 어플케이션에 대한 정보를 담는다
		// TODO Auto-generated method stub
		super.init(config);
		String path = config.getInitParameter("mapping");//이름이 mapping인 초기화 파라미터의 값을 읽음(위에서 설정)
		InputStream is = getServletContext().getResourceAsStream(path);//path의 자원(데이터)를 읽을 수 있는 stream 생성
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
		String cmd = request.getParameter("cmd");//properties에서 보낸 명령어를  저장
		String className = cmds.getProperty(cmd);//className 저장
		try {
			Command command = (Command) Class.forName(className).newInstance();//각 이름으로 value에 접근하여 객체를 생성
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
