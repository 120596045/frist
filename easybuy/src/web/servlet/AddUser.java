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
 * 添加用户信息和收货地址
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
			sex="0";		//男性为"0"
		}
		else
		{
			sex="1";		//女性为"1"
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
         * 将字符串类型转为日期类型
         */
    	Date date = DateUtil.String2Date(birth);
		user.setU_birth(new java.sql.Date(date.getTime()));
        
        /**
         * 向User表添加用户注册信息
         */
        UserBiz uDao = new UserImplement();
        uDao.addUser(user);
       
        Address address = new Address();
        address.setU_name(uname);
        address.setA_address(ads);
        
        /**
         * 向address表中添加用户名和地址信息
         */
        AddressBiz aBiz = new AddressImplement();
        aBiz.addAds(address);

        request.getRequestDispatcher("reg-result.jsp").forward(request,response);
	}

}
