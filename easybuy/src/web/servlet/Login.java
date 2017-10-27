package web.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import biz.UserBiz;
import biz.imple.UserImplement;
import entity.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBiz biz = new UserImplement();// 创建一个业务对象，调用登陆方法
		HttpSession session = request.getSession();// 创建一个session对象
		String error = null; // 错误信息
		// 获取用户输入用户名和密码以及验证码
		String name = request.getParameter("userId");
		String pwd = request.getParameter("password");
		String code = request.getParameter("code");
		// 获得当前系统给出的验证码
		String rand = (String) session.getAttribute("rand");

		// 放到user对象中
		User user = new User();
		user.setU_name(name);
		user.setU_password(pwd);
		List<User> list = biz.login(user);
		// 判断返回的集合是否为空，不为空的情况下说明在数据库中能够查询到该用户，同时判断用户输入的验证是否和系统生成验证码相同。
		if (code.equalsIgnoreCase(rand) && code != null) {
			// 验证码正确后进入账号和密码的判断
			if (list.size() > 0) {
				for (User n : list) {
					session.setAttribute("name", name);
					String privilege = n.getU_privilege();//权限
					session.setAttribute("privilege",privilege );
					response.sendRedirect("index.jsp");
					return;
				}
			} else {
				error = "用户名或密码错误";
				session.setAttribute("error", error);
				response.sendRedirect("login.jsp");
			}

		} else {// 当验证码验证失败
			error = "验证码错误";
			session.setAttribute("error", error);
			response.sendRedirect("login.jsp");
		}

	}

}
