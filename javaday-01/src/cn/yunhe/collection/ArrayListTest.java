package cn.yunhe.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList li =new ArrayList();
		
		li.add(new Student("zhangsan",18));
		li.add(new Student("lisi",21));
		li.add(new Student("wangwu",22));
		li.add(new Student("zhangsan",18));
		li.add(new Student("’‘∆ﬂ",19));
		li.add(new Student("zhangsan",18));
		li.add(new Student("’‘∆ﬂ",19));
		li.add("a");
		li.add("a");
		
		li =norepeat(li);
		
		print(li);

	}
	
	public static ArrayList  norepeat(ArrayList li){
		
		ArrayList list = new ArrayList();
		Iterator  it = li.iterator();
		
		while(it.hasNext()){
			Object obj = it.next();
		   if(!list.contains(obj)){
			   list.add(obj);
		   }
		}
		
		return list;
		
	}
	
	public static void print(ArrayList li){
		Iterator it = li.iterator();
		while(it.hasNext()){
			System.out.println(it.next())                                                                                                                                                                                 ;
		}
	}

}
