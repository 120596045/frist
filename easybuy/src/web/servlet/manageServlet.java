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
		 * ��̨����----����ҳ��----ҳ�� ��ҳ��ʾ��������
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
		 * ��̨����----�ظ�����ҳ��----��ȡ��1.��Ӧ���û����� ��������
		 */
		else if ("modify".equals(opr)) {
			String id = request.getParameter("id");
			Leave_messageDao lDao = new Leave_messageDaoImpl();
			Leave_message lm=lDao.selById(Integer.valueOf(id));
			session.setAttribute("messageByid", lm);
			response.sendRedirect("guestbook-modify.jsp");
		}

		/*
		 * ��̨����----�ظ�����ҳ��----��ȡ�ظ����ݣ������ݿ���� �޸� ����
		 */

		else if ("reply".equals(opr)) {
			// ��ȡ ��ǰʱ�䣬��ת��Ϊ���ݿ������������
			// Timestamp ts = new Timestamp(new Date().getTime());
			// Random r = new Random(); // ��ȡ һ�� ����� ����
			// int mid = r.nextInt();// r.nextInt()
			// ��������ȡһ���������valueOf���������������ת�����ַ�����

			// �� form �� name ֵ ��ȡ ����
			String content = request.getParameter("replyContent");
			// ��ȡ ��Ҫ�޸ĵ� ���� �� ID
			String id = request.getParameter("id");
			// ���� ʵ�������
			Leave_message lm = new Leave_message();
			lm.setM_id(Integer.valueOf(id));
			lm.setU_reply(content);
			lm.setM_state("�ظ����");
			// ����һ�� ҵ��� ʵ���� ����
			Leave_messageBiz lmb = new Leave_messageBizImpl();
			lmb.updateMessage(lm);
			System.out.println("�ظ�OK");
			response.sendRedirect("manage-result.jsp");
		}

		/**
		 * ͨ�� ID ɾ����������
		 */

		else if ("delete".equals(opr)) {
			String id = request.getParameter("id");
			// ����һ�� ҵ��� ʵ���� ����
			Leave_messageBiz lmb = new Leave_messageBizImpl();
			int p = lmb.deleteMessage(Integer.valueOf(id));
			System.out.println(p + "ɾ��OK");
			response.sendRedirect("guestbook.jsp");
		}
	}
}
