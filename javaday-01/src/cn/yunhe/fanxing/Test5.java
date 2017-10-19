package cn.yunhe.fanxing;

import java.util.List;

public class Test5 {

	public static  void main(String[] args) {
		
		 TestDemo4<String> te = new TestDemo4();

		    Student<String> stu2 = (Student<String>) te.getList();
		   
		      stu2.setName("aaa");
		      stu2.setAge(2);
		      stu2.show();
		
		  List <String> tlist = te.setList();
		  
		  List <String> alist = te.addList();
		  
		 
		  
		 

		
		

	}

}
