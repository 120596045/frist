package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Leave_message {

	  private Integer m_id;  // 留言的id序号
	  private String  m_content; // 留言内容
	  private Timestamp    m_create_date;//留言创建日期
	  private String  m_state;// 留言的状态
	  private String  u_name;//用户名
	  private String  u_reply;//回复的内容
	  
	  
	  
	public String getU_reply() {
		return u_reply;
	}
	public void setU_reply(String u_reply) {
		this.u_reply = u_reply;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public Timestamp getM_create_date() {
		return m_create_date;
	}
	public void setM_create_date(Timestamp m_create_date) {
		this.m_create_date = m_create_date;
	}
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	@Override
	public String toString() {
		return "Leave_message [m_id=" + m_id + ", m_content=" + m_content + ", m_create_date=" + m_create_date
				+ ", m_state=" + m_state + ", u_name=" + u_name + ", u_reply=" + u_reply + "]";
	}
	
}
