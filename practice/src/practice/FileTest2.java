package practice;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileTest2 {

	public static void main(String[] args) {
		File javaHome = new File("/Users/jungchaelin/storage/test1");
		// File 
		File[] files = javaHome.listFiles();
		for(File f : files) {
			System.out.println(f);
		}
		
		File test = new File("/Users/jungchaelin/storage/test1/sample.txt");
		boolean type1 = test.isDirectory();
		boolean type2 = test.isFile();
		String realType = test.isDirectory() ? " " : " ";
		System.out.println(" : "+ realType);
		
		String parent = test.getParent();
		System.out.println(" : "+parent);
		String name = test.getName();
		System.out.println(" : "+ name);
		String path = test.getPath();
		System.out.println(" : "+path);
		long millis = test.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(millis);
		System.out.println(" : "+date);
		long byteSize = test.length();
		double kbSize = (byteSize / 1024.0); 
		System.out.println(" : "+kbSize);
	}

	
}
