package cn.yunhe.extendsdemo;

public class ExtendsDome {

	public static void main(String[] args) {
		
		A sua= new A();
		B sub= new B();
		sua.setA(5);
		sua.setIJ(10,20);
		/*因为A是私有变量，因此sua.a无法打印
		 * 
		 * System.out.println("super.a="+sua.a);*/
		
       System.out.println("super.a="+sua.getA());
       System.out.println("super.i="+sua.i);
       System.out.println("super.j="+sua.j);
       System.out.println("super.sum="+sub.sum());
	}

}
/**
 * 
 * A是父类 
 */
class A{
	/** 
	 * 私有变量a无法调用
	 * 
	 */
	private int a=5;
	int i=7,j=8;
	void setA(int a){
		this.a=a;
	}
	/**
	 * 
	 * 私有变量在其他类中无法调取，使用get方法进行调用
	 */
	int getA(){
		return a;
	}
	void setIJ(int i,int j){
		this.i=i;
		this.j=j;
	}
}

class B extends A{
	int k;
	void setk(int k){
		this.k=k;
	}
	int sum(){
		
		System.out.println("A.a="+getA());
		
		return i+j+k;
	}
}