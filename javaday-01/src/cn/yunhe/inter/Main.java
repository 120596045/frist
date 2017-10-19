package cn.yunhe.inter;

public class Main {

	public static void main(String[] args) {
		Inter in = new Inter();
		System.out.println(in);
		in.monthed();
		
		Inter.Outer outer = new Inter.Outer();
		
		outer.show();
		
		Inter.Demo demo = new Inter().new Demo();
		
		demo.show();
	}

}
