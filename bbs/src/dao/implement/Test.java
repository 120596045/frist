package dao.implement;

import java.sql.Date;
import java.util.List;

import dao.MsgDao;
import entity.Message;

public class Test {
	
   public  static void main(String[] args){
	   MsgDao mDao = new MsgImpMybatis();
/*	   String uname= "zhangsan";
	   List<Message> list = mDao.selAll(uname);
	   for(Message n:list){
		   System.out.println(n.getMsgId()+";"+n.getMsgContent());
	   }*/
	   Message message = new Message();
	   message.setUname("zhangsan");
	   message.setMsgContent("22sss22");
	   message.setSendTo("lisi");
	   message.setTitle("11ssss1");
	   message.setMsgCreateDate(new Date(new java.util.Date().getTime()) );
	  int i = mDao.addMsg(message);
	  System.out.println(i);
   }
      
}
