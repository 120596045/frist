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
 * 后台管理控制器
 */
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		  this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		 String opr = request.getParameter("opr"); //取出请求参数
		 HttpSession session = request.getSession();//创建一个session
		 if("sall".equals(opr)){//判断查询除登陆用户外所有用户
			 String  name =(String) session.getAttribute("name");//获取登陆用户
			 int  pageIndex =1;
			 if(request.getParameter("pageIndex")!=null){
				 pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
			  }
			User user = new User();//创建用户对象
			user.setU_name("zhangsan");//需要session的名字
			Map map = new HashMap();
			map.put("u_name", "zhangsan");//需要session的名字
			map.put("pageIndex", (pageIndex-1)*3);//页面换算， 下标从0开始
			map.put("pageSize",3 );
			UserBiz uBiz = new UserImplement();//创建用户业务层对象
			List<User> list = uBiz.selByName(map);//查询除登陆用户外所有用户
			int ui = uBiz.selCount(user);//查询总用户数
			//session.setAttribute("ObjUser", list);
			ObjPage<User> objPage = new ObjPage();//创建一个页码对象
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
		 } else if("del".equals(opr)){//判断用户删除请求
			 //删除用户
			String id = request.getParameter("id");//获取用户id
			UserBiz uBiz =new UserImplement();
			int i =uBiz.delUser(Integer.valueOf(id));
			if(i>0){
				 //清空session 重新获取更新
				 session.removeAttribute("ObjUser");
				 response.sendRedirect("user.jsp");
			}
		 }else if("update".equals(opr)){//判断用户修改请求
			 //获取form表单用户数据 
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
			String birth = birthyear+"-"+birthmonth+"-"+birthday;//把生日年月日合成一个字符串
			User user =new User();//创建一个用户对象接受用户属性
			user.setU_id(Integer.valueOf(uId));
			user.setU_name(userName);
			user.setU_real_name(name);
			user.setU_password(passWord);
			user.setU_phone(mobile);
			//使用sql Date()方法进行时间转换
			//user.setU_birth(new java.sql.Date(Integer.valueOf(birthyear),Integer.valueOf(birthmonth),Integer.valueOf(birthday)));
			Date date = DateUtil.String2Date(birth);//把字符串转成时间格式
			user.setU_birth(new java.sql.Date(date.getTime()));//把时间转为long然后转成sql date格式
			UserBiz uBiz = new UserImplement();//创建一个业务对象，进行修改数据
			int i =uBiz.updateUser(user);
			if(i>0){//判断是否修改成功
				 //清空session 重新获取更新
				 session.removeAttribute("ObjUser");
				 response.sendRedirect("index.jsp");
			}
		 }
		 
	}

}
