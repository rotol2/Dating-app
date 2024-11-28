package pkg_objArr.controller;

import pkg_objArr.model.vo.Academy;

public class Run {

	public static void main(String[] args) {
		
		// 인덱스 이용
		Academy[] arr1 = new Academy[2];
		arr1[0] = new Academy("채린교육원", "010-111-1111");
		arr1[1] = new Academy("로롱교육원", "010-222-2222");

		System.out.println(arr1);
		System.out.println(arr1[0]);
//		System.out.println((arr1[1].getName()) + "\t" + (arr1[1].getPhone()));

		
		System.out.println();
		// for each 이용 
		for (Academy a : arr1) {
			System.out.println(a);
		}
		

	}
}
