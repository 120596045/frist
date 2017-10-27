package biz;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserBiz {
     
	/**
	 * �û���½��֤
	 * @param user
	 * @return
	 */
	public List<User> login(User user); 
	
	 /**
	  * ��ѯ�������Լ��������û�
	  * @return
	  */
	List<User> selByName(Map map);
	/**
	 * ��ѯ���û�����
	 */
	int selCount(User user);
	
	/**
	 * ͨ��idɾ���û�
	 */
	int delUser(int id);
	/**
	 * �޸��û�
	 */
	int updateUser(User user);
	/**
	 * ��ȡ���ݿ���ע����û�����Ϣ
	 * @param user
	 * @return
	 */
	 List<User> getUsers(User user);
		
	/**
	 * ����û�ע����Ϣ
	 * @param user
	 * @return
	 */
	 int addUser(User user);
}
