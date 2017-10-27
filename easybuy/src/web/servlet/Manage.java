package web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.UserBiz;
import biz.imple.UserImplement;
import entity.ObjPage;
import entity.User;
import util.DateUtil;

/**
 * Servlet implementation class Manage
 * ��̨���������
 */
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		  this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		 String opr = request.getParameter("opr"); //ȡ���������
		 HttpSession session = request.getSession();//����һ��session
		 if("sall".equals(opr)){//�жϲ�ѯ����½�û��������û�
			 String  name =(String) session.getAttribute("name");//��ȡ��½�û�
			 int  pageIndex =1;
			 if(request.getParameter("pageIndex")!=null){
				 pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
			  }
			User user = new User();//�����û�����
			user.setU_name("zhangsan");//��Ҫsession������
			Map map = new HashMap();
			map.put("u_name", "zhangsan");//��Ҫsession������
			map.put("pageIndex", (pageIndex-1)*3);//ҳ�滻�㣬 �±��0��ʼ
			map.put("pageSize",3 );
			UserBiz uBiz = new UserImplement();//�����û�ҵ������
			List<User> list = uBiz.selByName(map);//��ѯ����½�û��������û�
			int ui = uBiz.selCount(user);//��ѯ���û���
			//session.setAttribute("ObjUser", list);
			ObjPage<User> objPage = new ObjPage();//����һ��ҳ�����
			objPage.setCount(ui);
			objPage.setPageObj(list);
			//System.out.println(objPage);
			int pageTotal=0;
			if(ui%3==0){
				pageTotal=ui/3;
			}else{
				pageTotal = ui/3+1;
			}
			objPage.setPageIndex(pageIndex);
			objPage.setPageTotal(pageTotal);
			session.setAttribute("ObjUser", objPage);
			response.sendRedirect("user.jsp");
		 } else if("del".equals(opr)){//�ж��û�ɾ������
			 //ɾ���û�
			String id = request.getParameter("id");//��ȡ�û�id
			UserBiz uBiz =new UserImplement();
			int i =uBiz.delUser(Integer.valueOf(id));
			if(i>0){
				 //���session ���»�ȡ����
				 session.removeAttribute("ObjUser");
				 response.sendRedirect("user.jsp");
			}
		 }else if("update".equals(opr)){//�ж��û��޸�����
			 //��ȡform���û����� 
			String uId = request.getParameter("uId");
			String userName = request.getParameter("userName");
			String name = request.getParameter("name");
			String passWord = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			String birthyear = request.getParameter("birthyear");
			String birthmonth = request.getParameter("birthmonth");
			String birthday = request.getParameter("birthday");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String birth = birthyear+"-"+birthmonth+"-"+birthday;//�����������պϳ�һ���ַ���
			User user =new User();//����һ���û���������û�����
			user.setU_id(Integer.valueOf(uId));
			user.setU_name(userName);
			user.setU_real_name(name);
			user.setU_password(passWord);
			user.setU_phone(mobile);
			//ʹ��sql Date()��������ʱ��ת��
			//user.setU_birth(new java.sql.Date(Integer.valueOf(birthyear),Integer.valueOf(birthmonth),Integer.valueOf(birthday)));
			Date date = DateUtil.String2Date(birth);//���ַ���ת��ʱ���ʽ
			user.setU_birth(new java.sql.Date(date.getTime()));//��ʱ��תΪlongȻ��ת��sql date��ʽ
			UserBiz uBiz = new UserImplement();//����һ��ҵ����󣬽����޸�����
			int i =uBiz.updateUser(user);
			if(i>0){//�ж��Ƿ��޸ĳɹ�
				 //���session ���»�ȡ����
				 session.removeAttribute("ObjUser");
				 response.sendRedirect("index.jsp");
			}
		 }
		 
	}

}
