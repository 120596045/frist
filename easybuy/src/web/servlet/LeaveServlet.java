package web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import biz.Leave_messageBiz;
import biz.imple.Leave_messageBizImpl;
import entity.Leave_message;
import entity.ObjPage;


/**
 * Servlet implementation class LeaveSevelet
 */
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String name1 = request.getParameter("userId"); String pwd1 =
		 * request.getParameter("password");
		 * 
		 * if(name1.equals("lijiaqi") && pwd1.equals("123")) {
		 * 
		 * 
		 * request.getSession().setAttribute("user", name1); // 获取到 session
		 * 对象，为了一次会话都可以使用。， 把 username 值 以键值对 放进 session 范围内。
		 * response.sendRedirect("guestbook.jsp"); // session 带着 键值对 和 页面 一起 重定向
		 * 到 MsgServlet 页面。 } else { 大吉大利，今晚吃鸡！ request.setAttribute("error",
		 * "用户名或者密码错误"); //错误提示 放进 request 范围内 。
		 * request.getRequestDispatcher("login.jsp").forward(request, response);
		 * // 页面 转发到 index.jsp 页面 ，重新登陆 }
		 * 
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opr = null;
		opr = request.getParameter("opr");
		if ("getcontent".equals(opr)) {

			/**
			 * 获取留言内容 ，放进数据库，功能 ：需要获取 1.内容，2.创建时间，3.用户名。
			 */

			// 先创建一个 业务层 实现类 对象
			Leave_messageBiz lmb = new Leave_messageBizImpl();

			// 从 form 表单 name 值 获取 数据
			String name = request.getParameter("guestName");
			String content = request.getParameter("guestContent");
			// 获取 当前时间，并转化为数据库可用日期类型
			Timestamp ts = new Timestamp(new Date().getTime());
			// Random r = new Random(); // 获取 一个 随机数 对象
			// int mid = r.nextInt();// r.nextInt()
			// 方法，获取一个随机数，valueOf（）方法把随机数转换成字符串。

			// 创建 实体类对象
			Leave_message lm = new Leave_message();
			lm.setU_name(name);
			lm.setM_content(content);
			lm.setM_create_date(ts);
			lm.setM_state("未读");
			lm.setU_reply(null);
			lmb.addMessage(lm);
			System.out.println("留言OK");
			response.sendRedirect("guestbook.jsp");
		}

		/**
		 * 用户留言页面 ----- 页面 分页显示留言内容
		 */

		else {
			if ("page".equals(opr)) {
				int pageindex = 1, pagesize = 3;
				String index = request.getParameter("i");
				if (index != null) {
					pageindex = Integer.valueOf(index);
				}

				Leave_messageBizImpl lbi = new Leave_messageBizImpl();
				ObjPage pageobj = lbi.showLmByPage(pageindex, pagesize);
				request.getSession().setAttribute("pageobj", pageobj);
				response.sendRedirect("guestbook.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
