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
 * ��½��֤
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��������
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String error;// �ַ���������Ϣ��š�
		if ("login".equals(action)) {// �жϵ�½����
			// 1����ȡ��������������˻�����ƥ��
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			IUser iUser = new UserImplement();
			// ʵ��������ƥ���˻�������
			Map map = new  HashMap();
			map.put("name", name);
			map.put("password", password);			
			User user = iUser.userAll(map);// ����˻����������ƥ�䵽˵����½�ɹ�������Ϊtrue.
			if (user!=null) {
				//���������˻���Ϣ
				List<User> list = iUser.selAll(name);
				session.setAttribute("usersname", list);
				session.setAttribute("name", name);
				response.sendRedirect("content/mian.jsp");
				//request.getRequestDispatcher("/content/mian.jsp").forward(request, response);
			} else {
				error = "�û��˻����������";
				session.setAttribute("msg", error);//��Ŵ�����Ϣ
				request.getRequestDispatcher("index.jsp").forward(request, response);//ת����½ҳ��
			}
		}
		else if("regist".equals(action)){//�ж�ע������
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
						  error="ע��ɹ����½";
						  session.setAttribute("msg", error);
				          response.sendRedirect("index.jsp");
				          return;
					  }else{
						  error="�˻��ظ���ע��ʧ�ܣ�������";
						  session.setAttribute("msg", error);
						  response.sendRedirect("register.jsp");
						
					  }   
				}else{
					error = "�û��˻����������";
					session.setAttribute("msg", error);//��Ŵ�����Ϣ
					request.getRequestDispatcher("register.jsp").forward(request, response);//ת��ע��ҳ��
					
				}
			}else{
				error = "�û��������벻��Ϊ��";
				session.setAttribute("msg", error);//��Ŵ�����Ϣ
				request.getRequestDispatcher("register.jsp").forward(request, response);//ת��ע��ҳ��
			} 
		}
	}

}
