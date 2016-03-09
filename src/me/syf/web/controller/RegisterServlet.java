package me.syf.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import me.syf.domain.User;
import me.syf.exception.UserExistException;
import me.syf.service.IUserService;
import me.syf.service.Impl.UserServiceImpl;
import me.syf.util.WebUtils;
import me.syf.web.formbean.RegisterFormBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterFormBean formbean = WebUtils.request2Bean(request, RegisterFormBean.class);
		if (formbean.validate() == false) {
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}
		User user = new User();

		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);
			user.setId(WebUtils.makeId());// 设置用户的Id属性
			IUserService service = new UserServiceImpl();
			service.registerUser(user);
			String message = String.format("注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>",
					request.getContextPath() + "/login");
			
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserExistException e) {
			formbean.getErrors().put("username", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("aa");
			formbean.getErrors().put("message", "对不起，注册失败！");
			e.printStackTrace();
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
