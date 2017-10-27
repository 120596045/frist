package entity;

import java.util.List;

public class ObjPage<T> {
	   private Integer pageIndex;   //页码 
	   private Integer pageSize;//页面显示个数
	   private Integer count;//总页数
	   private Integer pageTotal; //可显示页数
	   private List<T> pageObj;//页面显示的对象
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;

	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<T> getPageObj() {
		return pageObj;
	}
	public void setPageObj(List<T> pageObj) {
		this.pageObj = pageObj;
	}
	   
}
