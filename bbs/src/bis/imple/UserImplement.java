package bis.imple;

import java.util.List;
import java.util.Map;

import bis.IUser;
import dao.UserDao;
import dao.implement.UserImpMybatis;
import entity.User;

public class UserImplement implements IUser {
    UserDao userDao = new UserImpMybatis();
	@Override
	public User userAll(Map map) {
	
		return userDao.userAll(map);
	}

	@Override
	public int addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public List<User> selAll(String name) {
		
		return userDao.selAll(name);
	}

}
