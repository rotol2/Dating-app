package pkg_capsul;

public class Account {
	private String owner;
	private int balance;
	
	public Account() {}
	
	public Account(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
		
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
