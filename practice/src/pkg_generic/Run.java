package pkg_generic;

public class Run {
	public static void main(String[] args) {
		
		Pair<String,Integer> p = new Pair<String, Integer>("apple",10);
		
		System.out.println(p.getfirst());
		System.out.println(p.getSecond());
		
		Pair<Integer,String> p2 = new Pair<Integer,String>(20,"orange");
		
		System.out.println(p2.getfirst());
		System.out.println(p2.getSecond());
		
	}
}
