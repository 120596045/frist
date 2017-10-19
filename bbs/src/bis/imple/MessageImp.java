package bis.imple;

import java.util.List;

import bis.IMessage;
import dao.MsgDao;
import dao.implement.MsgImpMybatis;
import entity.Message;

public class MessageImp implements IMessage {
    MsgDao msgDao =new MsgImpMybatis();
	@Override
	public List<Message> selAll(String uname) {
		
		return msgDao.selAll(uname);
	}
	@Override
	public int delById(Integer id) {
		
		return msgDao.delById(id);
	}
	@Override
	public int addMsg(Message msg) {
		
		return msgDao.addMsg(msg);
	}
	@Override
	public Message selByMsgId(Integer msgId) {
		
		return msgDao.selByMsgId(msgId);
	}
	@Override
	public int upByMsgId(Integer msgId) {
		
		return msgDao.upByMsgId(msgId) ;
	}

}
