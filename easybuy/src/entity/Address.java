package entity;

public class Address {
	private String a_id;		//地址id
	private String o_id;		//订单id
	private String u_name;		//用户名
	private String a_address;	//用户注册地址

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
