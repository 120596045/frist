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
		 * request.getSession().setAttribute("user", name1); // ��ȡ�� session
		 * ����Ϊ��һ�λỰ������ʹ�á��� �� username ֵ �Լ�ֵ�� �Ž� session ��Χ�ڡ�
		 * response.sendRedirect("guestbook.jsp"); // session ���� ��ֵ�� �� ҳ�� һ�� �ض���
		 * �� MsgServlet ҳ�档 } else { �󼪴���������Լ��� request.setAttribute("error",
		 * "�û��������������"); //������ʾ �Ž� request ��Χ�� ��
		 * request.getRequestDispatcher("login.jsp").forward(request, response);
		 * // ҳ�� ת���� index.jsp ҳ�� �����µ�½ }
		 * 
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opr = null;
		opr = request.getParameter("opr");
		if ("getcontent".equals(opr)) {

			/**
			 * ��ȡ�������� ���Ž����ݿ⣬���� ����Ҫ��ȡ 1.���ݣ�2.����ʱ�䣬3.�û�����
			 */

			// �ȴ���һ�� ҵ��� ʵ���� ����
			Leave_messageBiz lmb = new Leave_messageBizImpl();

			// �� form �� name ֵ ��ȡ ����
			String name = request.getParameter("guestName");
			String content = request.getParameter("guestContent");
			// ��ȡ ��ǰʱ�䣬��ת��Ϊ���ݿ������������
			Timestamp ts = new Timestamp(new Date().getTime());
			// Random r = new Random(); // ��ȡ һ�� ����� ����
			// int mid = r.nextInt();// r.nextInt()
			// ��������ȡһ���������valueOf���������������ת�����ַ�����

			// ���� ʵ�������
			Leave_message lm = new Leave_message();
			lm.setU_name(name);
			lm.setM_content(content);
			lm.setM_create_date(ts);
			lm.setM_state("δ��");
			lm.setU_reply(null);
			lmb.addMessage(lm);
			System.out.println("����OK");
			response.sendRedirect("guestbook.jsp");
		}

		/**
		 * �û�����ҳ�� ----- ҳ�� ��ҳ��ʾ��������
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
