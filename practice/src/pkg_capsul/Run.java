package pkg_capsul;

public class Run {

	public static void main(String[] args) {
		Account a = new Account("김철수",8000);
		
//		a.balance -=5000;
//		System.out.println(a.balance);

		int num = a.getBalance();
		
		if(num-5000 > 0) {
			a.setBalance(a.getBalance()-5000); 
			System.out.println("5000원 출금했습니다.\n잔액 : " +a.getBalance());
		} else {
			System.out.println("출금이 불가합니다.");
		}
		

	}
}
