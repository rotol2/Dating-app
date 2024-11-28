package pkg_set;

import java.util.Objects;

public class Student {
	private String name;
	private int age;

	public Student() {}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "{이름 =" + name + ", 나이=" + age + "}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (s.name.equals(name) && s.age == age) {
				result = true;
			}
		}
		return result;
	}

	
	
	
}
