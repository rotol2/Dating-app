package practice;

interface BicycleInterface {
//  
   public static final String BRAND = "Goodee";
   public static final int MAX_SPEED = 30;

//   
   public abstract void speedUp(int increment);

   public abstract void speedDown(int decrement);
}

class MountainBike implements BicycleInterface {
   private int speed;

   public int getSpeed() {
      return speed;
   }

   @Override
   public void speedUp(int increment) {
      if (speed + increment <= MAX_SPEED) {
         speed += increment;
         System.out.println(" " + increment + "");
      } else {
         System.out.println("test");
      }

   }

   @Override
   public void speedDown(int decrement) {
      if (speed - decrement < 0) {
         System.out.println("    .");
      } else {
         System.out.println(" " + decrement);
      }
   }
}

public class Test4 {
   public static void main(String[] args) {
      MountainBike mb = new MountainBike();
// System.out.println(mb.BRAND);
      System.out.println(BicycleInterface.BRAND);
      mb.speedUp(10);
      mb.speedUp(40);
      mb.speedDown(50);
      System.out.println("  : " + mb.getSpeed());
   }
}

