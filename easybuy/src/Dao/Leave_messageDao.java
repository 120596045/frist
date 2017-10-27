package Dao;

import java.util.List;
import java.util.Map;

import entity.Leave_message;


public interface Leave_messageDao {

	 /**
	  *    ���   ����   ����  
	  */
	 public int addMessage(Leave_message lm);
	 
	 /**
	  * ��ҳ��ѯ����ȡ��ǰҳ�� ���� 
	  */
	 public List<Leave_message> getLmByPage(Map map);
	
	 /**
	  *  ��ȡ  �ܼ�¼��
	  */
	 public int getCount();
	 
	 /**
	  *   ���ݿ�    �޸�    �ظ����� ���� 
	  */
	 public void updateMessage(Leave_message lm);
	 
	 /**
	  *    ��   ID ɾ��  ��������  
	  */
	 
	 public int deleteMessage(int i);
	 /**
	  *    ��   ID ��ѯ
	  */
	 Leave_message selById(int i); 
	 
}
