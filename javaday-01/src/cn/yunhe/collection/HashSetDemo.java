package cn.yunhe.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		
		hashSetTest();
		HashSet set2 = new HashSet();
		set2.add(9);

	}
	
	public static void hashSetTest(){
		Set set = new HashSet();
		set.add(1);
		set.add(new Student("张三",18));
		set.add(new Student("张三",18));
		System.out.println(set);
	}

}
