package cn.yunhe.neibulei;
/**
�����ֲ��ڲ���:
	�����м̳л���ʵ�ֽӿ� 
	new ����or�ӿ�(){������д�ķ��������Լ��ķ���}
ʹ�ó�����
	�����������ǽӿ�����ʱ�����ҽӿ��еķ�������������������ʹ��
	�����ڲ�����Ϊʵ�ʲ������д���
*/
public class TestDemo {
  public static void main(String[] args){
	  /*��ͨ��̬����*/
	  /*Student stu = new Student();*/
	  IPerson stu = new Student();
	  main(stu);
	  
	  /**
	   * ʹ��������ʵ��*/
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
	  /*Ĭ������ת�ͣ���Ϊ����ת��*/
	/*  Student stu2 =(Student) ip;
	  stu2.run();
	  stu2.show();*/
	  
	  ip.run();
	  ip.show();
  }
	
}



