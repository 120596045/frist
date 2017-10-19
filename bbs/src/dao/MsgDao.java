package dao;

import java.util.List;

import entity.Message;

/**
 * 信息接口
 * @author Administrator
 *
 */
public interface MsgDao {
  /**
   * 通过接收uname获取信息
   */
  public List<Message> selAll( String uname);
  /**
   * 通过接收uname删除信息
   */
  public int delById(Integer id);
  /**
   * 添加数据
   */
  public int addMsg(Message msg);
  /**
   * 根据msgId获取信息
   */
  public Message selByMsgId(Integer msgId);
  /**
   * 根据msgId修改状态
   */
  public int upByMsgId(Integer msgId);
}
