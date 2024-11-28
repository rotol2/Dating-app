package pkg_file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        
        
        
		File dir = new File("/Users/jungchaelin/storage");
		String uuid2 = UUID.randomUUID().toString();
		
		File file = new File(dir, uuid2 + ".txt");
		try {
			file.createNewFile();
			System.out.println("파일을 생성했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
