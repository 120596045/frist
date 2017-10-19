package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bis.IMessage;
import bis.imple.MessageImp;
import entity.Message;


public class MsgObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //通过登陆页面传过来的uname取出信息
	  HttpSession session = request.getSession();
	  Object name = session.getAttribute("name");
	  IMessage iMessage = new MessageImp();
	  List<Message> list =iMessage.selAll(name.toString());
	  if(list!=null){
		  session.setAttribute("msgObject", list);
		  response.sendRedirect("mian.jsp"); 
	  }else{
		  response.sendRedirect("miane.jsp"); 
	  }

	}

}
