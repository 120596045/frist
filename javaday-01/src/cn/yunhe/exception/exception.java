package cn.yunhe.exception;

public class exception{
	
	public static void main (String[] args)throws Myexception3{
       
	      int[] arr = new int[4];

		  show(arr);
		  
	}
	public static void show(int[] arr)throws Myexception3{
	
		if(arr==null){
	    throw new Myexception3("数组不能为空");
    }
  }
}


class Myexception3 extends Exception{
	public Myexception3(){}
	public Myexception3(String e){
		super(e);
	}
}

