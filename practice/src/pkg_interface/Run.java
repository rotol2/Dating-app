package pkg_interface;

public class Run {
	public static void main(String[] args) {

		MountainBike mb = new MountainBike();
		System.out.println(mb.BRAND);
//		System.out.println(BicycleInterface.BRAND);
		System.out.println("현재속도 : " + mb.getSpeed());
		mb.speedUp(10);
		System.out.println("현재속도 : " + mb.getSpeed());
		mb.speedUp(40);
		System.out.println("현재속도 : " + mb.getSpeed());
		mb.speedDown(10);
		System.out.println("현재속도 : " + mb.getSpeed());

	}
}
