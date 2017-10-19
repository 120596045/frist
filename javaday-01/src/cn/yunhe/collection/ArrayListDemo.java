package cn.yunhe.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListDemo {

	public static void main(String[] args) {
		  
		ArrayList list = new ArrayList();
		
		LinkedList llist = new LinkedList();
		
//		indexofDemo(list);
//        getDemo(list);
//	    setDemo(list);
		removefristDemo(llist);
	}
    
	public static void addDemo(ArrayList list ){
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(2, 'a');
		System.out.println(list);
	}
	
	public static void indexofDemo(ArrayList list){
		addDemo(list);
		System.out.println(list.indexOf(5));
	}
	
	public static void getDemo(ArrayList list){
		addDemo(list);
		Object obj = list.get(4);
		System.out.println(obj);
		
	}
	
	public static void setDemo(ArrayList list){
		addDemo(list);
		list.set(5, "ÁøÕ×µÏ");
		System.out.println(list);
		
	}
	
	public static void removefristDemo(LinkedList llist){
		llist.add("a");
		llist.add("b");
		llist.add("c");
		llist.removeFirst();
		
		System.out.println(llist.removeFirst());
	}
}
