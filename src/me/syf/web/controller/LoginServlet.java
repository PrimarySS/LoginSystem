package me.syf.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.syf.domain.User;
import me.syf.service.IUserService;
import me.syf.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		IUserService login = new UserServiceImpl();
		User user = login.loginUser(username, password);
		if(user == null)
		{
			String message = String.format("对不起，您输入的用户名或密码有误！3秒后将回到登陆页面...<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath()+"/login");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		String message = String.format("登陆成功！3秒后将回到首页...<meta http-equiv='refresh' content='3;url=%s'",
				request.getContextPath()+"/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
