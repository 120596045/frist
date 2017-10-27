package web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.el.lang.ELSupport;
import org.apache.ibatis.session.SqlSession;

import com.oracle.jrockit.jfr.RequestableEvent;
import com.sun.javafx.image.IntPixelGetter;
import com.sun.media.sound.RealTimeSequencerProvider;
import com.sun.xml.internal.ws.developer.StreamingAttachment;

import Dao.Leave_messageDao;
import Dao.imple.Leave_messageDaoImpl;
import biz.Leave_messageBiz;
import biz.imple.Leave_messageBizImpl;
import entity.Leave_message;
import entity.ObjPage;

/**
 * Servlet implementation class manageServlet
 */
public class manageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		/**
		 * 后台管理----留言页面----页面 分页显示留言内容
		 */
		String opr = request.getParameter("opr");

		if ("managepage".equals(opr)) {
			int pageindex = 1, pagesize = 3;
			String index = request.getParameter("j");
			if (index != null) {
				pageindex = Integer.valueOf(index);
			}
			Leave_messageBizImpl lbi = new Leave_messageBizImpl();
			ObjPage pageobj = lbi.showLmByPage(pageindex, pagesize);
			session.setAttribute("pageMessage", pageobj);
			System.out.println(session.getAttribute("pageMessage"));
			response.sendRedirect("guestbook.jsp");
		}

		/**
		 * 后台管理----回复留言页面----获取，1.对应的用户名和 留言内容
		 */
		else if ("modify".equals(opr)) {
			String id = request.getParameter("id");
			Leave_messageDao lDao = new Leave_messageDaoImpl();
			Leave_message lm=lDao.selById(Integer.valueOf(id));
			session.setAttribute("messageByid", lm);
			response.sendRedirect("guestbook-modify.jsp");
		}

		/*
		 * 后台管理----回复留言页面----获取回复内容，对数据库进行 修改 操作
		 */

		else if ("reply".equals(opr)) {
			// 获取 当前时间，并转化为数据库可用日期类型
			// Timestamp ts = new Timestamp(new Date().getTime());
			// Random r = new Random(); // 获取 一个 随机数 对象
			// int mid = r.nextInt();// r.nextInt()
			// 方法，获取一个随机数，valueOf（）方法把随机数转换成字符串。

			// 从 form 表单 name 值 获取 数据
			String content = request.getParameter("replyContent");
			// 获取 需要修改的 留言 的 ID
			String id = request.getParameter("id");
			// 创建 实体类对象
			Leave_message lm = new Leave_message();
			lm.setM_id(Integer.valueOf(id));
			lm.setU_reply(content);
			lm.setM_state("回复完成");
			// 创建一个 业务层 实现类 对象
			Leave_messageBiz lmb = new Leave_messageBizImpl();
			lmb.updateMessage(lm);
			System.out.println("回复OK");
			response.sendRedirect("manage-result.jsp");
		}

		/**
		 * 通过 ID 删除留言内容
		 */

		else if ("delete".equals(opr)) {
			String id = request.getParameter("id");
			// 创建一个 业务层 实现类 对象
			Leave_messageBiz lmb = new Leave_messageBizImpl();
			int p = lmb.deleteMessage(Integer.valueOf(id));
			System.out.println(p + "删除OK");
			response.sendRedirect("guestbook.jsp");
		}
	}
}
