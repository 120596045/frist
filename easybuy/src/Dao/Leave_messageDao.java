package Dao;

import java.util.List;
import java.util.Map;

import entity.Leave_message;


public interface Leave_messageDao {

	 /**
	  *    添加   留言   方法  
	  */
	 public int addMessage(Leave_message lm);
	 
	 /**
	  * 分页查询，获取当前页的 内容 
	  */
	 public List<Leave_message> getLmByPage(Map map);
	
	 /**
	  *  获取  总记录数
	  */
	 public int getCount();
	 
	 /**
	  *   数据库    修改    回复内容 操作 
	  */
	 public void updateMessage(Leave_message lm);
	 
	 /**
	  *    按   ID 删除  留言内容  
	  */
	 
	 public int deleteMessage(int i);
	 /**
	  *    按   ID 查询
	  */
	 Leave_message selById(int i); 
	 
}
