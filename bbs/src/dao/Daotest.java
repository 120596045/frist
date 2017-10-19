package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bis.IUser;
import dao.implement.UserImpMybatis;
import entity.User;

public class Daotest {

	public static void main(String[] args) {
		IUser userImp = new bis.imple.UserImplement();
		Map  map = new HashMap();
    	String name = "zhangsan";
     	String password = "1234";
		map.put("name", name);
		map.put("password",password);
        User user = userImp.userAll(map);
        if(user!=null){
        	System.out.println("11111");
        }
       
	}

}
