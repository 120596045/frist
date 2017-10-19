package dao.implement;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.UserDao;
import entity.User;
import util.MybitisFactory;

public class UserImpMybatis implements UserDao {

	   /**
	    * 匹配获取到的账户和密码
	    */
	
      public User userAll(Map map) {
  		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao =session.getMapper(UserDao.class);
		return uDao.userAll(map);
	}
	   /**
	    * 通过账户密码添加用户
	    * @param sql
	    * @param user
	    * @return
	    */

	@Override
	public int addUser(User user) {
		
		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao = session.getMapper(UserDao.class);
		int i = uDao.addUser(user);
		session.commit();//更新时必须
		session.close();
		return i;
	}
	  /**
	    * 查询所有用户
	    * @return
	    */
	@Override
	public List<User> selAll(String name) {
		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao = session.getMapper(UserDao.class);
		return uDao.selAll(name);
	}

}
