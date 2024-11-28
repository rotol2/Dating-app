package pkg_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		
		File dir = new File("/Users/jungchaelin/storage/sample1.txt");
		
		FileInputStream input = null;
		try {
			input = new FileInputStream(dir);
			
			byte[] b = new byte[(int)dir.length()];
			int idx = 0;
			
			while(true) {
				int c = input.read();
				// System.out.println(c);
				if(c == -1) {
					break;
				}
				b[idx++] = (byte)c;
				// System.out.println(new String(b));
			}
			
			String str = new String(b);
			System.out.println(str);
			
			input.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
