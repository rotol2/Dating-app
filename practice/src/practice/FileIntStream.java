package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIntStream {

	public static void main(String[] args) {
		File dir = new File("/Users/jungchaelin/storage/test1");
		File file = new File(dir, "sample1.txt");
		
		if(!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		// 1.
		FileInputStream in = null;
		try {
	         // 2.
	         in = new FileInputStream(file);
	         // 3.
	         byte[] b = new byte[(int) file.length()];
	         //int idx = 0;
	         // 4.
	         int c;

	         byte[] bytes = new byte[5];
	         int idx = 0;
	         while (true) {
	            int readByte = in.read(bytes);
	            if (readByte == -1) {
	               break;
	            }
	            System.arraycopy(bytes, 0, b, idx, readByte);
	            idx += bytes.length; // idx += readByte;
	         }
//	         while (true) {
//	            // read IOException
//	            c = in.read();
//	            if (c == -1) {
//	               break;
//	            }
//	            b[idx++] = (byte) c;
//	         }
	         String str = new String(b);
	         System.out.println(str);
	         //
	         in.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}

}
