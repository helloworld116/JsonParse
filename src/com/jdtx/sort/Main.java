package com.jdtx.sort;

public class Main {

	public static void main(String[] args) {
		// int i = 0;
		// i = i++;
		// System.out.println(i);
		// System.out.println(i);
		int shang = 9, yu = 0;
		String str = "";
		while (shang != 0) {
			yu = shang % 2;
			shang = shang / 2;
			str = yu + str;
		}
		System.out.println(str);
	}
}
