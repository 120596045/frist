package entity;

import java.sql.Date;

/**
 * ������Ϣʵ����
 * @author Administrator
 *
 */
public class Message {
  private int msgId; //��Ϣid
  private String uname;//������Ϣ������
  private String title;//��Ϣ����
  private String msgContent;//��Ϣ����
  private int state;// ��Ϣ״̬
  private String sendTo;//��Ϣ������
  private Date msgCreateDate;//��Ϣ����ʱ��
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
