package pkg_casting.practice.run;

import pkg_casting.practice.model.vo.Book;
import pkg_casting.practice.model.vo.Food;
import pkg_casting.practice.model.vo.Product;

public class run {
	public static void main(String[] args) {
		
		Product food = new Food("치킨",20000,3);
		Product book = new Book("자바의 정석",15000);
		
		System.out.println("치킨의 최종가격 : "+food.calculatePrice()); 
		System.out.println("자바의 정석 최종가격 : "+book.calculatePrice()); 
		
	}
}
