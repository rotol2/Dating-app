package pkg_file;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.text.SimpleAttributeSet;

public class InformationFile {
	public static void main(String[] args) {
		
		File javaHome = new File("/Users/jungchaelin/storage/test1");
		
		File[] files = javaHome.listFiles();
		for(File f : files) {
			System.out.println(f);
		}
		
		
		
		System.out.println();
		
		File test = new File("/Users/jungchaelin/storage/test1/test2.txt");
		boolean type1 = test.isDirectory();
		boolean type2 = test.isFile();
		
		String realType = test.isDirectory() ? "디렉토리" : "파일";
		System.out.println(" 유형 : "+ realType);
		
		
		
		System.out.println();
		
		String parent = test.getParent();
		System.out.println("상위 : " + parent);
		
		String name = test.getName();
		System.out.println("이름 : "+name);
		
		String path = test.getPath();
		System.out.println("경로 : "+path);
		
		
		
		System.out.println();
		
		long millis = test.lastModified();
		//System.out.println(millis);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(sdf);
		String date = sdf.format(millis);
		System.out.println("최종 수정일자 : "+date);
		
		
		
		System.out.println();
		
		long byteSize = test.length();
		//System.out.println(byteSize);
		double kbSize = (byteSize / 1024.0); 
		System.out.println("크기 : "+kbSize);
		
		
		
		
		
	}
}
