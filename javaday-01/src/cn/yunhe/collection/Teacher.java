package cn.yunhe.collection;

public class Teacher implements Comparable {
   
	private String name;
	private  int age;

	
	
	
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

	public Teacher(){}
    
	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public int compareTo(Object o) {
		Teacher te = (Teacher)o;
		int temp=this.age-te.age;
		return temp;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
