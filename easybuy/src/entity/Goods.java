package entity;

import java.sql.Date;

public class Goods {    
	private  int g_id;//商品id
	private String g_name;//商品名字
	private int g_count;//商品库存
	private String g_picture;//商品图片
	private String g_detail;//商品详情
	private String g_species;//商品物种
	private String g_sort;//商品种类
	private double g_price;//商品价格
	private Date g_create_date;//商品添加时间
		
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getG_count() {
		return g_count;
	}
	public void setG_count(int g_count) {
		this.g_count = g_count;
	}
	public String getG_picture() {
		return g_picture;
	}
	public void setG_picture(String g_picture) {
		this.g_picture = g_picture;
	}
	public String getG_detail() {
		return g_detail;
	}
	public void setG_detail(String g_detail) {
		this.g_detail = g_detail;
	}
	public String getG_species() {
		return g_species;
	}
	public void setG_species(String g_species) {
		this.g_species = g_species;
	}
	public String getG_sort() {
		return g_sort;
	}
	public void setG_sort(String g_sort) {
		this.g_sort = g_sort;
	}
	public double getG_price() {
		return g_price;
	}
	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", g_count=" + g_count + ", g_picture=" + g_picture
				+ ", g_detail=" + g_detail + ", g_species=" + g_species + ", g_sort=" + g_sort + ", g_price=" + g_price
				+ "]";
	}
	
	
}
