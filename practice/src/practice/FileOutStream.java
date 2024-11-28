package practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStream {

	   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      File dir = new File("/Users/jungchaelin/storage/test1");

		      if (!dir.exists()) {
		         dir.mkdirs();
		      }
		      // FileOutputStream out = new FileOutputStream(file);
		      File file = new File(dir, "sample1.txt");
		      FileOutputStream out = null;
		      //
		      try {
		         // FileOutputStream out = new FileOutputStream(file);
		         out = new FileOutputStream(file);
		         // String str = "헬로";
		         String str = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사"
		                 + "\n우리나라 만세 무궁화 삼천리 화려강산"
		                 + "\n대한사람 대한으로 길이 보전하세";
		         byte[] b = str.getBytes();
		         //
		         out.write(b);
		         // ( )
		         out.flush();
		         //
		         System.out.println(file.length() + " " + file.getPath());
		      } catch (IOException e) {
		         e.printStackTrace();
		      } finally {
		         //
		         try {
		            if (out != null) {
		               out.close();
		            }
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }

		   }

	
}
