package bis;

import java.util.List;
import entity.Message;

public interface IMessage {
	  /**
	   * ͨ������uname��ȡ��Ϣ
	   */
	  public List<Message> selAll( String uname);
	  /**
	   * ͨ������unameɾ����Ϣ
	   */
	  public int delById(Integer id);
	  /**
	   * �������
	   */
	  public int addMsg(Message msg);
	  /**
	   * ����msgId��ȡ��Ϣ
	   */
	  public Message selByMsgId(Integer msgId);
	  /**
	   * ����msgId�޸�״̬
	   */
	  public int upByMsgId(Integer msgId);
}
