package cn.yunhe.collection;

import java.util.Comparator;

public class ComparatorDome implements Comparator {

	 /***
	  * ���ֵ�˳���������
	  */
/*	@Override
	public int compare(Object o1, Object o2) {
		Teacher te = (Teacher)o1;
		Teacher te2 =(Teacher)o2;
		int temp = te.getAge()-te2.getAge();
		return temp==0?te.getName().compareTo(te2.getName()):temp;
		 
	}*/
     /***
	 * ���ַ����س��Ƚ�������Ƚ�������
	 */
/*	@Override
	public int compare(Object o1, Object o2) {
		Teacher te = (Teacher)o1;
		Teacher te2 =(Teacher)o2;
		int temp = te.getAge()-te2.getAge();
		return temp==0?te.getName().length()-te2.getName().length():temp;
		 
	}*/
	/***
	 * �ַ�����Ƚ�
	 */
	@Override
	public int compare(Object o1, Object o2) {
		String te = (String)o1;
		String te2 =(String)o2;
		int temp = te.length()-te2.length();
	    if(temp==0){
		   temp=te.compareTo(te2);
	   }
		return temp;
	}


}
