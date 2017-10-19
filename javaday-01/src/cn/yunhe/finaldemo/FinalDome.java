package cn.yunhe.finaldemo;

public class FinalDome {
	final static int AGE=21;
	final int b=2;
	public void menthod(){
		final int A;
		 A=3;
		int C=4; 
		
		System.out.println("成员静态常量AGE的值是"+AGE);
		System.out.println("成员常量b的值是"+b);
		System.out.println("局部常量A的值是"+A);
		System.out.println("局部变量C的值是"+C);
	}

}
