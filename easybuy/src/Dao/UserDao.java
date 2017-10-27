package Dao;

import java.util.List;
import java.util.Map;

import entity.User;

/**
 * �û���
 * @author Administrator
 *
 */
public interface UserDao {
  
	/**
	 * �û���½��֤
	 * @return
	 */
	 List<User> login(User user);
	
	 /**
	  * ��ѯ�������Լ��������û�
	  * @return
	  */
	List<User> selByName(Map map);
	
	/**
	 * ͨ��idɾ���û�ɾ��
	 */
	int delUser(int id);
	
	/**
	 * ��ѯ�������û�
	 * @return 
	 */
	int selCount(User user);
	
	/**
	 * �û��޸�
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

