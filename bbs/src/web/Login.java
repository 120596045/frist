package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bis.IUser;
import bis.imple.UserImplement;
import entity.User;

/**
 * 登陆验证
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求类型
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String error;// 字符串错误信息存放。
		if ("login".equals(action)) {// 判断登陆请求
			// 1、获取传过来的密码和账户进行匹配
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			IUser iUser = new UserImplement();
			// 实例化进行匹配账户和密码
			Map map = new  HashMap();
			map.put("name", name);
			map.put("password", password);			
			User user = iUser.userAll(map);// 如果账户和密码可以匹配到说明登陆成功，返回为true.
			if (user!=null) {
				//存入所有账户信息
				List<User> list = iUser.selAll(name);
				session.setAttribute("usersname", list);
				session.setAttribute("name", name);
				response.sendRedirect("content/mian.jsp");
				//request.getRequestDispatcher("/content/mian.jsp").forward(request, response);
			} else {
				error = "用户账户或密码错误";
				session.setAttribute("msg", error);//存放错误信息
				request.getRequestDispatcher("index.jsp").forward(request, response);//转发登陆页面
			}
		}
		else if("regist".equals(action)){//判断注册请求
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String password2 = request.getParameter("affirm");
			if(name!="" && password!=""){
				if(password.equals(password2)){
					User user = new User();
					user.setUname(name);
					user.setUpassword(password);
					IUser iUser = new UserImplement();
					int flag=iUser.addUser(user);
					  if(flag>0){
						  error="注册成功请登陆";
						  session.setAttribute("msg", error);
				          response.sendRedirect("index.jsp");
				          return;
					  }else{
						  error="账户重复，注册失败，请重试";
						  session.setAttribute("msg", error);
						  response.sendRedirect("register.jsp");
						
					  }   
				}else{
					error = "用户账户或密码错误";
					session.setAttribute("msg", error);//存放错误信息
					request.getRequestDispatcher("register.jsp").forward(request, response);//转发注册页面
					
				}
			}else{
				error = "用户密码密码不能为空";
				session.setAttribute("msg", error);//存放错误信息
				request.getRequestDispatcher("register.jsp").forward(request, response);//转发注册页面
			} 
		}
	}

}
