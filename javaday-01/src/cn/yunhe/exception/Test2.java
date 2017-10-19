package cn.yunhe.exception;

import org.apache.log4j.Logger;

import cn.yunhe.until.Logger4;

public class Test2 {
	
	/*private static Logger log = Logger.getLogger(Test2.class);*/
       
	private static Logger log=null; 
	
	public static void main(String[] args) {
		
		log=Logger4.log(Test2.class);
		
		int [] arr= new int[4];
		arr[0]=1;
		arr[2]=2;
		arr[3]=3;
		try{
			show(arr);
		}catch(TestException e){
			log.error(e.getMessage());
		}
	      finally{
	    	  System.out.println("你是大坏蛋"); 
	      }
	}

	
	public static void show(int[] arr) throws TestException{
		for(int i=0;i<10;i++){
			if(i>=4){
				throw new TestException("下标越界");			
			}
			/*System.out.println(arr[i]);*/
		}
	 }
	
	
}

class TestException extends Exception{
	
	public TestException(){}
	
	public TestException(String e){
		super(e);
	}
}