package cn.yunhe.exception;


public class Test3 {
	public static void main(String[] args){
		int[]arr=new int[4];
		try{
			run(arr,6);
		}catch(MyException2 e){
			System.out.println(e.toString());
		}
		
	}
	
	
 public static void run(int[] arr,int index) throws MyException2{
               
	if(index>arr.length){
		throw new MyException2("下标越界");
		}
	
      System.out.println(arr[index]);
	
 }
}


class MyException2 extends Exception{
	public MyException2(){}
	public MyException2(String e){	
		super(e);
	}
}