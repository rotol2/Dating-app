package pkg_file;

import java.io.File;
import java.io.IOException;

public class DirectoryExist {
	public static void main(String[] args) {
		
		File dir = new File("/Users/jungchaelin/storage/test");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		else {
			dir.delete();
		}	
		
		File file = new File(dir,"sample.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file.delete();
		}
		
		
		
		
	}	
}
