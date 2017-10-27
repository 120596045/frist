package test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.Leave_messageDao;
import Dao.UserDao;
import Dao.imple.Leave_messageDaoImpl;
import Dao.imple.UserImp;
import entity.Leave_message;
import entity.User;
import util.DateUtil;
public class Test {
	public static void main(String[]args){
	/*	GoodsPage gPage = new GoodsPage();
		gPage.setPageIndex(0);
		gPage.setPageSize(6);
		GoodsDao gDao = new GoodsImp();
		List<Goods> list = gDao.selAll(gPage);		
		System.out.println(list);*/
		
		/*User user = new User();
		String name="zhangsan";
		user.setU_name(name);*/
/*		UserDao uDao = new UserImp();
		int i = uDao.delUser(11);
		System.out.println(i);*/
	/*	User user = new User();
		user.setU_id(10);
		user.setU_name("zhaoyun");
		user.setU_password("1234");
		Date date = DateUtil.String2Date("1988-12-12");
		user.setU_birth(new java.sql.Date(date.getTime()));
		UserDao uDao = new UserImp();
		int i = uDao.updateUser(user);
		System.out.println(i);*/
		
		Leave_messageDao lDao = new Leave_messageDaoImpl();
		Leave_message lm=lDao.selById(5);
		System.out.println(lm);
	}
	
	
}
