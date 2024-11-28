package pkg_set;

import java.util.HashSet;
import java.util.Set;

public class HashSetObj {
	public static void main(String[] args) {
		
		// 기본 요소 추가
		Set<String> set1 = new HashSet<String>(); 
		set1.add("봄");
		set1.add("여름");
		set1.add("봄");
		set1.add("가을"); 
		set1.add("겨울");
		
		System.out.println(set1);
		
		// 객체 요소 추가
		Set<Student> set2 = new HashSet<Student>();
		set2.add(new Student("김철수",15));
		set2.add(new Student("홍길동",21));
		set2.add(new Student("김철수",15));
		
		System.out.println(set2);
		
	}
}
