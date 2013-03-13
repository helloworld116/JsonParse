package com.jdtx.sort;

import com.google.gson.Gson;

class Person {

//	private String name;
	private int age;
	private String gender;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

public class TestPerson {
	public static void main(String[] args) {
		fromJson();
	}
	
	public static void toJson(){
		Person person = new Person();
		person.setAge(23);
		person.setGender("男");
//		person.setName("张三");
		Gson gson = new Gson();
		String data = gson.toJson(person);
		System.out.println(data);
	}
	
	public static void fromJson(){
		String info = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\"}";
		Gson gson = new Gson();
		Person person = gson.fromJson(info, Person.class);
		System.out.println(person.getAge());
	}
}
