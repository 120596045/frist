package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bis.IMessage;
import bis.imple.MessageImp;
import entity.Message;
import util.DateUtil;

public class Remsg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		 HttpSession session =request.getSession();
		 String error;
		//ȡ��sendto,�����ˣ�Ȼ����ݷ����˽�����Ϣ����
		String sendTo = request.getParameter("toUser");//���ŷ�
		String uname = request.getParameter("uname");//���ͷ�
		String title =request.getParameter("title");//����
		String msgContent = request.getParameter("content");//����
		Message message = new Message();
		message.setUname(sendTo);
		message.setSendTo(uname);
		message.setTitle(title);
		message.setMsgContent(msgContent);
		message.setState(0);
		message.setMsgCreateDate(new Date(new java.util.Date().getTime()));
		IMessage iMessage = new MessageImp();
		int count = iMessage.addMsg(message);
		   if(count>0){
			   error="���ͳɹ�";
			   session.setAttribute("error", error);
			  response.sendRedirect("mian.jsp");
		   }else{
			   error="����ʧ��";
			   session.setAttribute("error", error);
			   response.sendRedirect("mian.jsp");
			   }
		
	}

}
