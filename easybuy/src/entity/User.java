package entity;

import java.sql.Date;

public class User {     
	private int u_id;//�û�id 
	private String u_name;//�û�����
	private String u_real_name;//�û���������
	private String u_password;//�û�����
	private String u_phone;//�û��绰
	private String u_sex;//0���� 1��Ů
	private String u_email;//�û�����
	private Date u_birth;//�û�����
	private String u_card;//�û����֤
	private String u_privilege;//����ԱȨ��0 ��ͨ 2 ����Ա
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_real_name() {
		return u_real_name;
	}
	public void setU_real_name(String u_real_name) {
		this.u_real_name = u_real_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public Date getU_birth() {
		return u_birth;
	}
	public void setU_birth(Date u_birth) {
		this.u_birth = u_birth;
	}
	public String getU_card() {
		return u_card;
	}
	public void setU_card(String u_card) {
		this.u_card = u_card;
	}
	public String getU_privilege() {
		return u_privilege;
	}
	public void setU_privilege(String u_privilege) {
		this.u_privilege = u_privilege;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_real_name=" + u_real_name + ", u_password="
				+ u_password + ", u_phone=" + u_phone + ", u_sex=" + u_sex + ", u_email=" + u_email + ", u_birth=" + u_birth
				+ ", u_card=" + u_card + ", u_privilege=" + u_privilege + "]";
	}
	
	
}


