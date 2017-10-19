package cn.yunhe.fanxing;

public class Student<T> {
	private String name;
	private int age;

	public Student(){}
	public Student(String name,int age) {
		this.name=name;
		this.age=age;
	}

	public <T> void show() {
		System.out.println("student-------show");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
