package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
   public static void main(String[] args) {
      // 1.
      File dir = new File("/Users/jungchaelin/storage");
      // 2.
      File file = new File(dir, "sample1.txt");
      // 3.
      FileReader in = null;
      try {
         // 4.
         in = new FileReader(file);
         // 5.
         int c = 0;
         StringBuilder sb = new StringBuilder();
         // 6.
         while (true) {
            c = in.read();
            if (c == -1) {
               break;
            }
            sb.append((char) c);
         }
         System.out.println(sb.toString());
         // 7.
         in.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}