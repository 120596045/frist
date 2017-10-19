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
	    * ƥ���ȡ�����˻�������
	    */
	
      public User userAll(Map map) {
  		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao =session.getMapper(UserDao.class);
		return uDao.userAll(map);
	}
	   /**
	    * ͨ���˻���������û�
	    * @param sql
	    * @param user
	    * @return
	    */

	@Override
	public int addUser(User user) {
		
		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao = session.getMapper(UserDao.class);
		int i = uDao.addUser(user);
		session.commit();//����ʱ����
		session.close();
		return i;
	}
	  /**
	    * ��ѯ�����û�
	    * @return
	    */
	@Override
	public List<User> selAll(String name) {
		SqlSession session = MybitisFactory.getSqlSession();
		UserDao uDao = session.getMapper(UserDao.class);
		return uDao.selAll(name);
	}

}
