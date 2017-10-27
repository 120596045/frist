package Dao;

import java.util.List;
import java.util.Map;

import entity.User;

/**
 * 用户表
 * @author Administrator
 *
 */
public interface UserDao {
  
	/**
	 * 用户登陆验证
	 * @return
	 */
	 List<User> login(User user);
	
	 /**
	  * 查询不包含自己的所有用户
	  * @return
	  */
	List<User> selByName(Map map);
	
	/**
	 * 通过id删除用户删除
	 */
	int delUser(int id);
	
	/**
	 * 查询所有用用户
	 * @return 
	 */
	int selCount(User user);
	
	/**
	 * 用户修改
	 */
	int updateUser(User user);
	
	/**
	 * 获取数据库已注册的用户名信息
	 * @param user
	 * @return
	 */
	 List<User> getUsers(User user);
		
	/**
	 * 添加用户注册信息
	 * @param user
	 * @return
	 */
	 int addUser(User user);
	}

