package biz.imple;

import java.util.List;
import java.util.Map;

import Dao.UserDao;
import Dao.imple.UserImp;
import biz.UserBiz;
import entity.User;

public class UserImplement implements UserBiz {

	UserDao uDao = new UserImp();
	/**
	 * µÇÂ½ÑéÖ¤
	 */
	@Override
	public List<User> login(User user) {
		
		return uDao.login(user);
	}
	@Override
	public List<User> selByName(Map map) {
		
		return uDao.selByName(map);
	}
	@Override
	public int selCount(User user) {
		
		return uDao.selCount(user);
	}
	@Override
	public int delUser(int id) {
		
		return uDao.delUser(id);
	}
	@Override
	public int updateUser(User user) {
		return uDao.updateUser(user);
	}
	@Override
	public List<User> getUsers(User user) {
		
		return uDao.getUsers(user);
	}
	@Override
	public int addUser(User user) {
		
		return uDao.addUser(user);
	}

}
