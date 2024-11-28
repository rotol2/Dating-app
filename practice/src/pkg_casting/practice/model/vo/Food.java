package pkg_casting.practice.model.vo;

public class Food extends Product{

	private int expirationDays;
	
	public Food(String name, int price, int expirationDays) {
		super(name,price);
		this.expirationDays = expirationDays;
	}
	
	public int calculateDiscountRate() {	
		int day;
		if(expirationDays<=1) {
			return day=80;
		}else if(expirationDays<=5) {
			return day=50;
		}else if(expirationDays<=10) {
			return day=20;
		}else {
			return day=0;
		}		
	}
	
	@Override
	public int calculatePrice() {
		int origin = super.getPrice();
		int now = origin-(origin*calculateDiscountRate()/100);
		return now;
	}
	
	public int getExpirationDays() {
		return expirationDays;
	}

	
}
