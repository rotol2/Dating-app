package pkg_generic;

public class Pair<T,U> {
	private T first;
	private U second;
	
	public Pair() {}
	
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getfirst() {
		return first;
	}
	
//	public void setfirst(T first) {
//		this.first = first;
//	}

	public U getSecond() {
		return second;
	}

//	public void setSecond(U second) {
//		this.second = second;
//	}
	
	
	
}
