package cn.yunhe.extendsdemo;

public class ExtendsDome {

	public static void main(String[] args) {
		
		A sua= new A();
		B sub= new B();
		sua.setA(5);
		sua.setIJ(10,20);
		/*��ΪA��˽�б��������sua.a�޷���ӡ
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
 * A�Ǹ��� 
 */
class A{
	/** 
	 * ˽�б���a�޷�����
	 * 
	 */
	private int a=5;
	int i=7,j=8;
	void setA(int a){
		this.a=a;
	}
	/**
	 * 
	 * ˽�б��������������޷���ȡ��ʹ��get�������е���
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