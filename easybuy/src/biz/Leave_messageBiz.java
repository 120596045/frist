package biz;

import entity.Leave_message;
import entity.ObjPage;

public interface Leave_messageBiz {

	/**
	  *    ���   ����   ����  
	  */
	 public int addMessage(Leave_message lm);
	 
	 /**
	  *    ��ҳ  ��ʾ  �������� 
	  */
	 public ObjPage showLmByPage(int pageindex,int pagesize);
	 
	 /**
	  *   ���ݿ�    �޸�    �ظ����� ���� 
	  */
	 
	 public void updateMessage(Leave_message lm);
	 
	 /**
	  *   ͨ��ID ɾ����������
	  */
	 
	 public int deleteMessage(int i);
	 
	 
}
