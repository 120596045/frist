package dao.implement;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.MsgDao;
import entity.Message;
import util.MybitisFactory;

public class MsgImpMybatis implements MsgDao {
	  /**
	   * 通过接收uname获取信息
	   */
	@Override
	public List<Message> selAll(String uname) {
		SqlSession session = MybitisFactory.getSqlSession();
		MsgDao mDao = session.getMapper(MsgDao.class );
		return mDao.selAll(uname);
	}
	  /**
	   * 通过接收Id删除信息
	   */
	@Override
	public int delById(Integer id) {
		SqlSession session = MybitisFactory.getSqlSession();
		MsgDao mDao = session.getMapper(MsgDao.class );
		int i =mDao.delById(id);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public int addMsg(Message msg) {
		SqlSession session = MybitisFactory.getSqlSession();
		MsgDao mDao = session.getMapper(MsgDao.class );
		int i =mDao.addMsg(msg);
		session.commit();
		session.close();
		return i;
	}
	
	  /**
	   * 根据msgId获取信息
	   */
	@Override
	public Message selByMsgId(Integer msgId) {
		SqlSession session = MybitisFactory.getSqlSession();
		MsgDao mDao = session.getMapper(MsgDao.class );
		return mDao.selByMsgId(msgId);
	}
	  /**
	   * 根据msgId修改状态
	   */
	@Override
	public int upByMsgId(Integer msgId) {
		SqlSession session = MybitisFactory.getSqlSession();
		MsgDao mDao = session.getMapper(MsgDao.class );
		int i =mDao.upByMsgId(msgId);
		session.commit();
		session.close();
		return i;
	}

}
