package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
   /**
    * 匹配获取到的账户和密码
    */
   public User userAll(Map map);
   /**
    * 通过账户密码添加用户
    * @param sql
    * @param user
    * @return
    */
   public int addUser(User user);
   /**
    * 查询所有用户
    * @return
    */
   public List<User> selAll(String name);
}
