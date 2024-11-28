package pkg_file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBuffer {
	public static void main(String[] args) {
		
		File dir = new File("/Users/jungchaelin/storage");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "sample3.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			String str1 = "how are you?\n";
			String str2 = "i'm fine thank you";
			bos.write(str1.getBytes());
			bos.write(str2.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
