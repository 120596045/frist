package entity;

import java.sql.Date;

public class News {
	
	
	private String n_title;
	private Integer n_id;
	private String n_content;
	private String u_name;
	private Date n_create_date;
	
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public Integer getN_id() {
		return n_id;
	}
	public void setN_id(Integer n_id) {
		this.n_id = n_id;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public Date getN_create_date() {
		return n_create_date;
	}
	public void setN_create_date(Date n_create_date) {
		this.n_create_date = n_create_date;
	}
	
	@Override
	public String toString() {
		return "News [n_title=" + n_title + ", n_id=" + n_id + ", n_content=" + n_content + ", u_name=" + u_name
				+ ", n_create_date=" + n_create_date + "]";
	}
	
}
