package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bis.IMessage;
import bis.imple.MessageImp;


public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              /*
               * ͨ�������û�ɾ������
               * 1����ȡ�û���
               * 2��ȥ������
               * 3��ɾ��
               */
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		   HttpSession session =request.getSession();
		   String id = request.getParameter("id");
		   String error;
		   IMessage iMessage = new MessageImp();
		   int count = iMessage.delById(Integer.valueOf(id));
		   if(count>0){
			   error="ɾ���ɹ�";
			   session.setAttribute("error", error);
			  response.sendRedirect("mian.jsp");
		   }else{
			   error="ʧ�ܳɹ�";
			   session.setAttribute("error", error);
			   response.sendRedirect("mian.jsp");
			   }
	}

}
