package web.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.AddressBiz;
import biz.UserBiz;
import biz.imple.AddressImplement;
import biz.imple.UserImplement;
import entity.Address;
import entity.User;
import util.DateUtil;


/**
 * ����û���Ϣ���ջ���ַ
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
        String uname = request.getParameter("userId");
        String realname = request.getParameter("userName");
        String upwd = request.getParameter("password");
        String sex = request.getParameter("sex");
        if(sex.equals("male"))
		{
			sex="0";		//����Ϊ"0"
		}
		else
		{
			sex="1";		//Ů��Ϊ"1"
		}
        String birth = request.getParameter("birthday");
        String card = request.getParameter("identityCode");
        String email = request.getParameter("email");
        String phone = request.getParameter("mobile");
        String ads = request.getParameter("address");
        
        User user = new User();
        user.setU_name(uname);
        user.setU_real_name(realname);
        user.setU_password(upwd);
        user.setU_sex(sex);
        user.setU_card(card);
        user.setU_email(email);
        user.setU_phone(phone);
        
        /**
         * ���ַ�������תΪ��������
         */
    	Date date = DateUtil.String2Date(birth);
		user.setU_birth(new java.sql.Date(date.getTime()));
        
        /**
         * ��User������û�ע����Ϣ
         */
        UserBiz uDao = new UserImplement();
        uDao.addUser(user);
       
        Address address = new Address();
        address.setU_name(uname);
        address.setA_address(ads);
        
        /**
         * ��address��������û����͵�ַ��Ϣ
         */
        AddressBiz aBiz = new AddressImplement();
        aBiz.addAds(address);

        request.getRequestDispatcher("reg-result.jsp").forward(request,response);
	}

}
