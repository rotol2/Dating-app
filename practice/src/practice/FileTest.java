package practice;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File dir = new File("/Users/jungchaelin/storage/test1");
		// dir.mkdir();
		// mkdir :
//		dir.mkdirs();
//		dir.delete();

	// 메서드 생성 없이 만든 코드
//		if(dir.exists()) {
//			File dir1 = new File("/Users/jungchaelin/storage/test1/sample.txt");
//			if(dir1.exists()) {
//				dir1.delete();
//			}
//			dir.delete();
//		} else {
//			dir.mkdirs();
//			File file = new File(dir,"sample.txt");
//	         if(!file.exists()) {
//	            try {
//	               file.createNewFile();
//	            } catch (IOException e) {
//	               e.printStackTrace();
//	            }
//	         }
//		}
				
		if(dir.exists()) {
			deleteDir(dir);
		} else {
			dir.mkdirs();
			File file = new File(dir,"sample.txt");
	         if(!file.exists()) {
	            try {
	               file.createNewFile();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
		}
		
	}
	
	// 재귀
	public static boolean deleteDir(File dir) {
		// 경로인지 확인(=폴더인지)
		if(dir.isDirectory()) {			
			String[] subDir = dir.list();
			for(int i=0; i<subDir.length; i++) {
				boolean result = deleteDir(new File(dir,subDir[i]));
				if(!result) {
					return false;
				}
			}
		}
		
		return dir.delete();
	}
	
	
	
	
}
