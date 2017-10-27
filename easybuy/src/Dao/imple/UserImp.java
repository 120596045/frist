package Dao.imple;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.UserDao;
import entity.User;
import util.MybatisUtil;

public class UserImp implements UserDao {
   /**
    * 用户登陆验证
    */
	@Override
	public List<User> login(User user) {
       SqlSession session = MybatisUtil.getSqlSession();
       UserDao uDao = session.getMapper(UserDao.class);
	   return uDao.login(user);
	}
  
	/**
	 * 用户删除
	 */
	@Override
	public int delUser(int id) {
	  SqlSession session = MybatisUtil.getSqlSession();
	   UserDao uDao = session.getMapper(UserDao.class);
	   int i =uDao.delUser(id);
	   session.commit();
	   return i;
	}
	/**查询不包含自己的用户
	 * 
	 */
	@Override
	public List<User> selByName(Map map) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    UserDao uDao = session.getMapper(UserDao.class);
		return uDao.selByName(map);
	}
	@Override
	public int selCount(User user) {
	   SqlSession session = MybatisUtil.getSqlSession();
	   UserDao uDao = session.getMapper(UserDao.class);
	   int i = uDao.selCount(user);
		return i;
	}
	@Override
	public int updateUser(User user) {
		  SqlSession session = MybatisUtil.getSqlSession();
		   UserDao uDao = session.getMapper(UserDao.class);
		   int i =uDao.updateUser(user);
		   session.commit();
		   return i;
	}
	/**
	 *通过用户名查询用户是否存在
	 */
	@Override
	public List<User> getUsers(User user) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    UserDao uDao = session.getMapper(UserDao.class);
		return uDao.getUsers(user);
	}
	 /**
     * 用户添加
     */
	@Override
	public int addUser(User user) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    UserDao uDao = session.getMapper(UserDao.class);
	    int i = uDao.addUser(user);
	    session.commit();
		return i;
	}


}
