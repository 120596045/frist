package Dao.imple;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.Leave_messageDao;
import entity.Leave_message;
import util.MybatisUtil;


public class Leave_messageDaoImpl implements Leave_messageDao {
	 /**
     *     ��� ���� ��Ϣ
     */
	@Override     
	public int addMessage(Leave_message lm) 
	{
         
		   int row = 0;
		SqlSession session = MybatisUtil.getSqlSession();
		
		Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
		      row = lmd.addMessage(lm);
		      session.commit();
		      session.close();
		return row;
	}
               /**
                *    ��ȡ ��ҳ��ѯ  ���� 
                * @return
                */
	@Override
	public List<Leave_message> getLmByPage(Map map) {
	   List<Leave_message> list = new ArrayList<Leave_message>();
		   
		   SqlSession session = MybatisUtil.getSqlSession();
		   Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
		   list = lmd.getLmByPage(map);
		        session.commit();
		        session.close();
		    return list;
		
	}
          /**
           *     ��ȡ  �ܵļ�¼�� ��������
           */
	@Override
	public int getCount() {
	     int count = 0;
	     SqlSession session =  MybatisUtil.getSqlSession();
	    Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
		count = lmd.getCount();
		session.commit();
        session.close();
		return count;
	}
	
			 /**
			  *   ���ݿ�    �޸�    �ظ����� ���� 
			  */
		@Override
		public void updateMessage(Leave_message lm) {
			SqlSession session = MybatisUtil.getSqlSession();
			Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
			lmd.updateMessage(lm);
			session.commit();
			session.close();
		}
		
		 /**
		  *    ��   ID ɾ��  ��������  
		  */
		
			@Override
			public int deleteMessage(int i) {
               SqlSession session = MybatisUtil.getSqlSession();
			   Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
			    int p = lmd.deleteMessage(i);	
			   session.commit();
			   session.close();
				return p;
			}
			
			/**
			  *    ��   ID ��ѯ
			  */	
		@Override
		public Leave_message selById(int i) {
            SqlSession session = MybatisUtil.getSqlSession();
			Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
			return lmd.selById(i);
		}
	
	
}
