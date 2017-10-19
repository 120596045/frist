package cn.yunhe.inter;

public class Inter {
	
    public static void	monthed(){
    	
        class  Test{
			
			public void show(){
				
				System.out.println("不要打印我");
			}		   
 		}
		/* Test test = new Test();
		  test.show();*/
	}
    static class Outer{
    	public void show(){
    		System.out.println("___________________");
    	}
    }
    
    class Demo{
    	public void show(){
    		System.out.println("===================");		
    	}
    }
    
}
