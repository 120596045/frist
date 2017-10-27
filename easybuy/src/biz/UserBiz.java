package biz;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserBiz {
     
	/**
	 * 用户登陆验证
	 * @param user
	 * @return
	 */
	public List<User> login(User user); 
	
	 /**
	  * 查询不包含自己的所有用户
	  * @return
	  */
	List<User> selByName(Map map);
	/**
	 * 查询总用户数据
	 */
	int selCount(User user);
	
	/**
	 * 通过id删除用户
	 */
	int delUser(int id);
	/**
	 * 修改用户
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
