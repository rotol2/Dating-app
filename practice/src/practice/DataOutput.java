package practice;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class DataOutput {
   public static void main(String[] args) {
      File dir = new File("/Users/jungchaelin/storage/test1");
      if (!dir.exists()) {
         dir.mkdirs();
      }

      File file = new File(dir, "sample4.txt");

      //
      DataOutputStream out = null;

      try {

         //
         out = new DataOutputStream(new FileOutputStream(file));

         //
         String name = "홍길동";
         int age = 10;
         double height = 140.5;
         boolean isAdult = (age >= 20);
         char gender = '남';

         //
         out.writeUTF(name);
         out.writeInt(age);
         out.writeChar(gender);
         out.writeDouble(height);
         out.writeBoolean(isAdult);
         //
         out.flush();
         //
         out.close();

         //
         System.out.println(file.length() + "바이트 크기의");

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
