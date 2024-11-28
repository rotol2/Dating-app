package practice;

import java.io.File;
import java.io.IOException;

public class FIleInfoTest {

	public static void main(String[] args) {
		File dir = new File("/Users/jungchaelin/storage/test1");
		
//		if (dir.exists() && dir.isDirectory()) {
//            // 디렉터리의 파일 목록 가져오기
//            File[] fileList = dir.listFiles();
//
//            // 파일 목록이 존재하는지 확인
//            if (fileList != null) {
//                // 파일 목록 출력
//                for (File file : fileList) {
//                    if (file.isDirectory()) {
//                        System.out.println("Directory: " + file.getName());
//                    } else {
//                        System.out.println("File: " + file.getName());
//                    }
//                }
//            } else {
//                System.out.println("The directory is empty or an error occurred.");
//            }
//        } else {
//            System.out.println("The specified path is not a directory or does not exist.");
//        }
//	}		
		
		if (dir.exists()) {
//			deleteDir(dir);
			printDir(dir);
		} else {
			dir.mkdirs();
			File file = new File(dir, "sample.txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 재귀호출로 모든 경로 출력
	public static void printDir(File dir) {
		// 경로인지 확인(=폴더인지)
		if (dir.isDirectory()) {
			System.out.println("Directory : "+dir.getAbsolutePath());
			File[] file1 = dir.listFiles();
			for(File f : file1) {
				printDir(f);
			}
		} else {
			System.out.println("file : "+dir.getAbsolutePath());
		}
	}

	// 재귀호출로 모든 경로 삭제
	public static boolean deleteDir(File dir) {
		// 경로인지 확인(=폴더인지)
		if (dir.isDirectory()) {
			String[] subDir = dir.list();
			for (int i = 0; i < subDir.length; i++) {
				boolean result = deleteDir(new File(dir, subDir[i]));
				if (!result) {
					return false;
				}
			}
		}
		return dir.delete();
	}
	
	
}


