package entity;

import java.util.List;

public class ObjPage<T> {
	   private Integer pageIndex;   //ҳ�� 
	   private Integer pageSize;//ҳ����ʾ����
	   private Integer count;//��ҳ��
	   private Integer pageTotal; //����ʾҳ��
	   private List<T> pageObj;//ҳ����ʾ�Ķ���
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
