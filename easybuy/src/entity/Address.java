package entity;

public class Address {
	private String a_id;		//��ַid
	private String o_id;		//����id
	private String u_name;		//�û���
	private String a_address;	//�û�ע���ַ

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getA_address() {
		return a_address;
	}

	public void setA_address(String a_address) {
		this.a_address = a_address;
	}

	@Override
	public String toString() {
		return "Address [a_id=" + a_id + ", o_id=" + o_id + ", u_name=" + u_name + ", a_address=" + a_address + "]";
	}

}
