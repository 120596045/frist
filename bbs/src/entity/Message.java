package entity;

import java.sql.Date;

/**
 * 短信消息实体类
 * @author Administrator
 *
 */
public class Message {
  private int msgId; //消息id
  private String uname;//接受信息人名字
  private String title;//消息标题
  private String msgContent;//消息内容
  private int state;// 消息状态
  private String sendTo;//消息发送人
  private Date msgCreateDate;//消息发送时间
public int getMsgId() {
	return msgId;
}
public void setMsgId(int msgId) {
	this.msgId = msgId;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMsgContent() {
	return msgContent;
}
public void setMsgContent(String msgContent) {
	this.msgContent = msgContent;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getSendTo() {
	return sendTo;
}
public void setSendTo(String sendTo) {
	this.sendTo = sendTo;
}
public Date getMsgCreateDate() {
	return msgCreateDate;
}
public void setMsgCreateDate(Date time) {
	this.msgCreateDate = time;
}
  
}
