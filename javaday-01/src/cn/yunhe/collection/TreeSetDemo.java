package cn.yunhe.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		/***
		 * 使用传参方式选择比较构造器
		 */
		TreeSet set = new TreeSet(new ComparatorDome());
		
		comparable(set);

	} 
	
	/***
	 * 类实现Comparable比较构造器，重写方法进行判断
	 * @param set
	 */
	public static void comparable(TreeSet set){
		
		/*set.add(new Teacher("aaa",22));
		set.add(new Teacher("bb",22));
		set.add(new Teacher("a",22));*/
		set.add("abc");
		set.add("aeeewww");
		set.add("awwq");
		set.add("aw");
		set.add("ax");
		set.add("asssdf");
		set.add("bca");
		print(set);
	}
	
	
	
	public static void print(TreeSet set){
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
