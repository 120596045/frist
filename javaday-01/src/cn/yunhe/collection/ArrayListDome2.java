package cn.yunhe.collection;

public class ArrayListDome2 {

	public static void main(String[] args) {
	  NewArrayList list = new NewArrayList();
	  
	  list.add(1);
	  list.add(2);
	  list.add(1);
	  list.add(2);
	  list.add(new Student("张三",19));
	  list.add(new Student("张三",19));
	  list.addIndex(1, 3);
	  System.out.println(list);
	}

}
