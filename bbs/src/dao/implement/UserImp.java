package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.UserDao;
import entity.User;
import util.Jdbc;

public class UserImp implements UserDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
   /**
    * 通过账户和密码匹配登陆
    */
	
	public  boolean userAll(String name,String password) {
	     boolean flag=false;
	    conn = Jdbc.getConnection();
	    try {
			pst = conn.prepareStatement("select * from user where uname=? and upassword=?");
			pst.setString(1, name);
			pst.setString(2, password);
		    rs =pst.executeQuery();
		    if(rs.next()){
		    	flag=true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.getClose(conn, pst, rs);
		}
		return flag;
	}
  
	/**
	 * 注册添加用户
	 */

	public int addUser(String sql, Object[] user) {
		  int j = 0;
		    conn = Jdbc.getConnection();
		    try {
				pst = conn.prepareStatement(sql);
				for(int i=0;i<user.length;i++){
					pst.setObject(i+1, user[i]);
				}
			  j=  pst.executeUpdate();
			 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				Jdbc.getClose(conn, pst, rs);
			}
		 return j;
	}
/**
 * 查询所有用户
 */
	@Override
	public List<User> selAll(String name) {
		List<User> list = new  ArrayList<User>();
		conn = Jdbc.getConnection();
		try {
		pst = conn.prepareStatement("select * from user where uname!=?");
		pst.setString(1, name);
		rs = pst.executeQuery();
		while(rs.next()){
		   User user = new User();
		   user.setUid(rs.getInt(1));
		   user.setUname(rs.getString(2));
		   user.setUpassword(rs.getString(3));
		   list.add(user);
		 }
		 return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.getClose(conn, pst, rs);
		}
		
		return null;
	}

@Override
public User userAll(Map map) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int addUser(User user) {
	// TODO Auto-generated method stub
	return 0;
}



}
