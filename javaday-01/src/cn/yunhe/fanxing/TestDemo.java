package cn.yunhe.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestDemo {

	public static void main(String[] args) {
//		test1();
		/*List<Student> list = new ArrayList<Student> ();
		print(list);*/
		test3();
	}

	public static void test1() {
		Map map = new HashMap();
		map.put("name", "zhangsan");
		System.out.println(map);
	}
	
	public static void test2(List<Student> list){		
		list.add(new Student("zhangsan",24));
		list.add(new Student("lisi",21));
		list.add(new Student("wangwu",18));
		list.add(new Student("maliu",23));	
		
	}
	public static void print(List<Student> list){
		list.add(new Student("zhangsan",24));
		list.add(new Student("lisi",21));
		list.add(new Student("wangwu",18));
		list.add(new Student("maliu",23));
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student stu = it.next();
			stu.show();
		}
		
	} 
	
	public static void test3(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "ÕÔËÄ");
		map.put("age", 29);
		map.put("sex", true);
		map.put("hobby", "´òÀºÇò");
	 	  
		Set<Map.Entry<String, Object>> set = map.entrySet();
//		System.out.println(set);
		
		Iterator<Map.Entry<String, Object>> it = set.iterator();
		while(it.hasNext()){		
			Entry<String, Object> entry = it.next();
         System.out.println(entry.getKey()+"="+entry.getValue());
		}
	   
	}
}
