package practice;

import java.io.File;
import java.io.FileWriter;

public class FileWrite {

   public static void main(String[] args) {
      // 1. 
      File dir = new File("/Users/jungchaelin/storage");
      if (!dir.exists()) {
         dir.mkdirs();
      }
      // 2. 파일 객체 생성
      File file = new File(dir, "sample2.txt");
      // 3. 파일 출력 스트림 선언
      FileWriter fw = null;
      try {
         // 4. 파일 출력 스트림 생성
         fw = new FileWriter(file);
         // 5. 출력할 데이터 구성
         int ch = '대';
         char[] chArr = { '한', '민' };
         String str = "국/n짱!";
         // 6. 출력
         fw.write(ch);
         fw.write(chArr);
         fw.write(str);

         // 7. 닫기
         fw.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}

  