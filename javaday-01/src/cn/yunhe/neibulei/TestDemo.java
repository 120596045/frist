package cn.yunhe.neibulei;
/**
匿名局部内部类:
	必须有继承或者实现接口 
	new 父类or接口(){子类重写的方法或者自己的方法}
使用场景：
	当函数参数是接口类型时，而且接口中的方法不超过三个，可以使用
	匿名内部类作为实际参数进行传递
*/
public class TestDemo {
  public static void main(String[] args){
	  /*普通多态调用*/
	  /*Student stu = new Student();*/
	  IPerson stu = new Student();
	  main(stu);
	  
	  /**
	   * 使用匿名类实现*/
/*	  main(new IPerson(){
		 public void run(){
			  System.out.println("IP----run");
		  }
		 public void show(){
			  System.out.println("IP----show");
		  }
	  });*/
	  
  }
  
  
  public static void main(IPerson ip){
	  /*默认向上转型，此为向下转型*/
	/*  Student stu2 =(Student) ip;
	  stu2.run();
	  stu2.show();*/
	  
	  ip.run();
	  ip.show();
  }
	
}



