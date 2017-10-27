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
     *     添加 留言 信息
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
                *    获取 分页查询  内容 
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
           *     获取  总的记录数 ，总条数
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
			  *   数据库    修改    回复内容 操作 
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
		  *    按   ID 删除  留言内容  
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
			  *    按   ID 查询
			  */	
		@Override
		public Leave_message selById(int i) {
            SqlSession session = MybatisUtil.getSqlSession();
			Leave_messageDao lmd = session.getMapper(Leave_messageDao.class);
			return lmd.selById(i);
		}
	
	
}
