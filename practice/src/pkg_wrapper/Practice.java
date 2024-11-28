package pkg_wrapper;

public class Practice {

	public void printSum(String one, String two) {
		int changeOne = Integer.parseInt(one);
		int changeTwo = Integer.parseInt(two);
		
		int total = changeOne+changeTwo;
		System.out.println("두 수의 합 : "+total);
	}
	
}
