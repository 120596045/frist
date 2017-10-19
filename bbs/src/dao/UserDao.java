package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
   /**
    * ƥ���ȡ�����˻�������
    */
   public User userAll(Map map);
   /**
    * ͨ���˻���������û�
    * @param sql
    * @param user
    * @return
    */
   public int addUser(User user);
   /**
    * ��ѯ�����û�
    * @return
    */
   public List<User> selAll(String name);
}
