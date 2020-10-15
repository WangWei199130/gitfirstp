package com.git.thread;

public class Test5 {
	public static void main(String[] args) {
		Person p1 = new Test5().new Person("xiaowang", 10,1);
		System.out.println(p1.hashCode());
		p1.setSerial(p1.getSerial()+1);
		System.out.println(p1.hashCode());
		p1.setSerial(p1.getSerial()+1);
		System.out.println(p1.hashCode());
		p1.setSerial(p1.getSerial()+1);
		System.out.println(p1.hashCode());
		p1.setSerial(p1.getSerial()+1);
		System.out.println(p1.hashCode());
		

	}
	
class Person {
	
	private int serial = 0;
	
	private String name;
	
	private int age;
	
	public Person(String name,int age,int serial){
		this.serial = serial;
		this.name = name;
		this.age = age;
	}
	
	

	public int getSerial() {
		return serial;
	}



	public void setSerial(int serial) {
		this.serial = serial;
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

//	@Override
//	public int hashCode() {
//		return serial;
//		//return (this.getName()+this.getAge()).hashCode();
//	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj != null && obj instanceof Person){
			Person another = (Person)obj;
			// 姓名相等
			boolean isCommonName = (this.getName() == null && another.getName()==null) || (this.getName().equals(another.getName()));
			boolean isCommonAge = this.getAge() == another.getAge();
			if(isCommonName && isCommonAge){
				return true;
			}
		}
		return false;
	}
	
}

}
