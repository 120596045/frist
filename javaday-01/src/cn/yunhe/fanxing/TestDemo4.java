package cn.yunhe.fanxing;

import java.util.ArrayList;
import java.util.List;

public class TestDemo4<T> {


		
	  public Student<?> getList(){
			
			Student<?> stu = new Student();			
			 stu.show();
			return stu;
	}
		
	public List<T> setList(){
			
			List<T> list = new ArrayList();
			return list;
	}
	
	public List<T> addList(){
		
		List<T> list = new ArrayList();
		return list;
}
}
