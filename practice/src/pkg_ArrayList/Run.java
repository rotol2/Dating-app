package pkg_ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(new Product("사과",1000));
		al.add(new Product("바나나",2000));
		al.add(new Product("딸기",3000));
		
		for(Product p : al) {
			System.out.println(p);
		}
		
		
		System.out.println();
		
		al.remove(1);
		al.set(0,new Product("오렌지",15000));
		
		System.out.println("오렌지 있어요?" +al.contains(new Product("오렌지",15000)));
			
		
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}

		System.out.println();
		
		
		List<String> list = new ArrayList<>();
		System.out.println(list.isEmpty());
		System.out.println(list.contains("사과"));
		

		System.out.println();		
		
		list.add("사과");
		list.add("딸기");
		
		if(list.isEmpty()){ 
			System.out.println("비어있어요.");
		}else{
			System.out.println("사과가 포함되어 있어요. "+list.contains("사과"));
		}
		
		
		System.out.println();
		
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
		
		

		
	}
}
