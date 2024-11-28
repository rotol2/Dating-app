package pkg_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test2FileInputStream {
	public static void main(String[] args) {
		
		File file = new File("/Users/jungchaelin/storage/sample2.txt");
		
		FileInputStream input2 = null;
		
		try {			
			input2 = new FileInputStream(file);
			
			byte[] b = new byte[(int)file.length()];
			byte[] bytes = new byte[5];
			
			int idx = 0;
			
			while(true) {
				int readByte = input2.read(bytes);
				if(readByte == -1) {
					break;
				}
				System.arraycopy(bytes, 0, b, idx, readByte);				
				idx += readByte;
				
				// ======= 원리 확인을 위한 코드 ==========
//				System.out.println("b : "+new String(b));
//				System.out.println("readByte : "+readByte);
//				System.out.println("idx : "+idx);
//				System.out.println();
				// ===================================
			}
			
			String str = new String(b);
			System.out.println(str);
			
			input2.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
