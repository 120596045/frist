package cn.yunhe.fanxing;

public class Teacher {
    private String name;
    private int age;
    
    public Teacher(String name,int age) {
		this.name=name;
		this.age=age;
	}
    
    public void show(){
    	System.out.println("teacher-------show");
    }
}
