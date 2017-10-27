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
		UserBiz biz = new UserImplement();// ����һ��ҵ����󣬵��õ�½����
		HttpSession session = request.getSession();// ����һ��session����
		String error = null; // ������Ϣ
		// ��ȡ�û������û����������Լ���֤��
		String name = request.getParameter("userId");
		String pwd = request.getParameter("password");
		String code = request.getParameter("code");
		// ��õ�ǰϵͳ��������֤��
		String rand = (String) session.getAttribute("rand");

		// �ŵ�user������
		User user = new User();
		user.setU_name(name);
		user.setU_password(pwd);
		List<User> list = biz.login(user);
		// �жϷ��صļ����Ƿ�Ϊ�գ���Ϊ�յ������˵�������ݿ����ܹ���ѯ�����û���ͬʱ�ж��û��������֤�Ƿ��ϵͳ������֤����ͬ��
		if (code.equalsIgnoreCase(rand) && code != null) {
			// ��֤����ȷ������˺ź�������ж�
			if (list.size() > 0) {
				for (User n : list) {
					session.setAttribute("name", name);
					String privilege = n.getU_privilege();//Ȩ��
					session.setAttribute("privilege",privilege );
					response.sendRedirect("index.jsp");
					return;
				}
			} else {
				error = "�û������������";
				session.setAttribute("error", error);
				response.sendRedirect("login.jsp");
			}

		} else {// ����֤����֤ʧ��
			error = "��֤�����";
			session.setAttribute("error", error);
			response.sendRedirect("login.jsp");
		}

	}

}
