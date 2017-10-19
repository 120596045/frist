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
               * 通过接收用户删除数据
               * 1、获取用户名
               * 2、去除数据
               * 3、删除
               */
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		   HttpSession session =request.getSession();
		   String id = request.getParameter("id");
		   String error;
		   IMessage iMessage = new MessageImp();
		   int count = iMessage.delById(Integer.valueOf(id));
		   if(count>0){
			   error="删除成功";
			   session.setAttribute("error", error);
			  response.sendRedirect("mian.jsp");
		   }else{
			   error="失败成功";
			   session.setAttribute("error", error);
			   response.sendRedirect("mian.jsp");
			   }
	}

}
