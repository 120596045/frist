package cn.yunhe.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		/***
		 * ͨ����̬������һ��List����
		 */
		List list = new ArrayList();
	
		List list2 = new ArrayList();
         
//		addDemo(list);
		addAll(list,list2);
		
	}
	  /***
	   * ͨ��add()�������listԪ�ض���
	   * @param list
	   */
	 public static void  addDemo(List list){
		 list.add("a");
		 list.add('a');
		 list.add(3);
		 list.add(null);
		 list.add(6);
		 print(list);
	 }
	 /***
	  * ͨ��addAll()������Ӽ���
	  * @param list
	  * @param list2
	  */
	 public static void addAll(List list,List list2){
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list2.add("a");
		 list2.add("b");
		 list2.add("c");
		 list2.add("d");
		 list.addAll(2,list2);
		 print(list);
	 }
	 /***
	  * ͨ�����������б���ѭ��List����
	  * @param list
	  */
	 public static void print(List list){
		 Iterator it =  list.iterator();
		 while(it.hasNext()){
			 System.out.println(it.next());
		 }
	 }

}
