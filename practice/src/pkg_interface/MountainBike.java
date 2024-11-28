package pkg_interface;

public class MountainBike implements BicycleInterface{

    private int speed;
    
    public int getSpeed() { 
    	return speed; 
    }
    
    @Override
    public void speedUp(int increment) {
		if(speed+increment <= MAX_SPEED) {
		speed += increment; 
			System.out.println("속도를 "+increment+"만큼 증가시켰습니다.");
		}else {
			System.out.println("최대 속도를 초과하여 가속할 수 없습니다.");
		}	
    }

	@Override
	public void speedDown(int decrement) {
        if(speed - decrement < 0) {
            System.out.println("음의 속도로 갈 수 없습니다.");
        }else {
        	speed -= decrement;
            System.out.println("속도를 "+decrement+"만큼 감소시켰습니다.");
        }
	}
    
}
