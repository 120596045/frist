package  web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserBiz;
import biz.imple.UserImplement;
import entity.User;



/**
 * �жϵ�ǰ�û����Ƿ�ע��(�������ݿ�)
 */

public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
        String uname = request.getParameter("userId");
                
        User user = new User();
        user.setU_name(uname);
        
        UserBiz uDao = new UserImplement();

		List<User> list=uDao.getUsers(user);
		int flag = 1;
		if(list.size()>0){
			//ע��ʧ��
			flag = -1;
		}
		
       	PrintWriter out = response.getWriter();
		out.write(""+flag);
		
		out.flush();
		out.close();     

	}

}
