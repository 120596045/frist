package Dao.imple;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.UserDao;
import entity.User;
import util.MybatisUtil;

public class UserImp implements UserDao {
   /**
    * �û���½��֤
    */
	@Override
	public List<User> login(User user) {
       SqlSession session = MybatisUtil.getSqlSession();
       UserDao uDao = session.getMapper(UserDao.class);
	   return uDao.login(user);
	}
  
	/**
	 * �û�ɾ��
	 */
	@Override
	public int delUser(int id) {
	  SqlSession session = MybatisUtil.getSqlSession();
	   UserDao uDao = session.getMapper(UserDao.class);
	   int i =uDao.delUser(id);
	   session.commit();
	   return i;
	}
	/**��ѯ�������Լ����û�
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
	 *ͨ���û�����ѯ�û��Ƿ����
	 */
	@Override
	public List<User> getUsers(User user) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    UserDao uDao = session.getMapper(UserDao.class);
		return uDao.getUsers(user);
	}
	 /**
     * �û����
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
