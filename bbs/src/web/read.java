package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bis.IMessage;
import bis.imple.MessageImp;
import entity.Message;

public class read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//���ݴ�������msgId��ѯ��Ϣ
		String msgId = request.getParameter("msgId");
		//�޸���Ϣ״̬����Ϊ�Ѷ�
		IMessage iMessage = new MessageImp();
		iMessage.upByMsgId(Integer.valueOf(msgId));
		Message message =iMessage.selByMsgId(Integer.valueOf(msgId));
		session.setAttribute("messageById", message);
		response.sendRedirect("readMsg.jsp");
	}

}
