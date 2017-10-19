package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MsgDao;
import entity.Message;
import util.Jdbc;

public class MsgImp implements MsgDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
   /**
    * 通过接收人获取消息
    */
	@Override
	public List<Message> selAll(String uname) {
		conn = Jdbc.getConnection();
		List<Message> list = new ArrayList<Message>();
		try {
		pst = conn.prepareStatement("select * from message where uname=?");
		pst.setString(1, uname);
		rs = pst.executeQuery();
		while(rs.next()){
			Message message = new Message();
			message.setMsgId(rs.getInt(1));
			message.setUname(rs.getString(2));
			message.setTitle(rs.getString(3));
			message.setMsgContent(rs.getString(4));
			message.setState(rs.getInt(5));
			message.setSendTo(rs.getString(6));
			message.setMsgCreateDate(rs.getDate(7));
			list.add(message);
		  }
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
/**
 * 通过uname 删除消息信息
 */
@Override
public int delById(Integer id) {
	int count=0 ;
	conn = Jdbc.getConnection();
	try {
		pst = conn.prepareStatement("delete from message where msgid=?");
		pst.setInt(1, id);
	   count = pst.executeUpdate();
	} catch (SQLException e) {

		e.printStackTrace();
	}finally{
		Jdbc.getClose(conn, pst, rs);
	}
	
	return count;
}
@Override
public int addMsg(Message msg) {
	int count =0;
	conn = Jdbc.getConnection();
	try {
		pst = conn.prepareStatement("insert into message(uname,title,msgContent,state,sendTo,msg_create_date)value(?,?,?,?,?,?) ");
	    pst.setString(1, msg.getUname());
	    pst.setString(2, msg.getTitle());
	    pst.setString(3, msg.getMsgContent());
	    pst.setInt(4, msg.getState());
	    pst.setString(5,msg.getSendTo());
	    pst.setDate(6,new java.sql.Date(new java.util.Date().getTime()) );
	   count = pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		
	}finally{
		Jdbc.getClose(conn, pst, rs);
	}
	return count;
}
/**
 * 根据id查询信息
 */
@Override
public Message selByMsgId(Integer msgId) {
	Message message = new Message();
	conn = Jdbc.getConnection();
	try {
	pst = conn.prepareStatement("select * from message where msgid=?");
	pst.setInt(1, msgId);
	rs = pst.executeQuery();
	if(rs.next()){
		message.setMsgId(rs.getInt(1));
		message.setUname(rs.getString(2));
		message.setTitle(rs.getString(3));
		message.setMsgContent(rs.getString(4));
		message.setState(rs.getInt(5));
		message.setSendTo(rs.getString(6));
		message.setMsgCreateDate(rs.getDate(7));	
	 }
	  return message;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 根据id修改状态
 */
@Override
public int upByMsgId(Integer msgId) {
	int count=0;
	conn = Jdbc.getConnection();
	try {
	pst =conn.prepareStatement("update message set state=1 where msgid=?");
	pst.setInt(1, msgId);
	count = pst.executeUpdate();
	return count;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
}

}
