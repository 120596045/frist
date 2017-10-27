package biz;

import entity.Leave_message;
import entity.ObjPage;

public interface Leave_messageBiz {

	/**
	  *    添加   留言   方法  
	  */
	 public int addMessage(Leave_message lm);
	 
	 /**
	  *    分页  显示  留言内容 
	  */
	 public ObjPage showLmByPage(int pageindex,int pagesize);
	 
	 /**
	  *   数据库    修改    回复内容 操作 
	  */
	 
	 public void updateMessage(Leave_message lm);
	 
	 /**
	  *   通过ID 删除留言内容
	  */
	 
	 public int deleteMessage(int i);
	 
	 
}
