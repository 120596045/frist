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
		//取出sendto,发信人，然后根据发信人建立信息数据
		String sendTo = request.getParameter("toUser");//收信方
		String uname = request.getParameter("uname");//发送方
		String title =request.getParameter("title");//标题
		String msgContent = request.getParameter("content");//内容
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
			   error="发送成功";
			   session.setAttribute("error", error);
			  response.sendRedirect("mian.jsp");
		   }else{
			   error="发送失败";
			   session.setAttribute("error", error);
			   response.sendRedirect("mian.jsp");
			   }
		
	}

}
