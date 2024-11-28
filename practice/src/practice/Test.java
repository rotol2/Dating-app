package practice;

public class Test {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String[] students = { " ", " ", " " };
      for (int i = 0; i < students.length; i++) {
         Student s = new Student();
         // s.printNo(i+1);
         // s.printName(students[i]);
         s.printInfo(i);
         s.printInfo(students[i]);
      }

   }

}

class Student {
//   
   public void printInfo(int idx) {
      System.out.println("  " + idx + " .");
   }

//   
   public void printInfo(String name) {
      System.out.println("  " + name + " .");
   }

//  , , 
   public void printInfo(int idx, String name) {
   }
//  
//public void printInfo(int age) {
//
// }
}
