package com.jdtx.sort;

interface A{
	int y = 0;
}
class B {
	int x= 1;
}
public class Pr extends B implements A {
	public void printX(){
		System.out.println(x);
	}
	public static void main(String[] args) {
		new Pr().printX();
	}
}
