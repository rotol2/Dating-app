package pkg_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {

		// 무조건 생성 모드
		File dir = new File("/Users/jungchaelin/storage");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 파일 생성
		File file = new File(dir, "sample1.txt");
		FileOutputStream out = null;
		// 파일 출력 스트림 선언
		try {
					// 생성 모드 )
			out = new FileOutputStream(file);
					// 추가 모드일 때 )
					// out = new FileOutputStream(file,true);
		// 출력할 데이터 구성
			String str = "hello";
					// 추가 모드 내용 )
					// String str = "my name is cl";
			byte[] b = str.getBytes();
		// 출력
			out.write(b);
		// 플러싱(선택)
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		// 파일 출력 시스템 닫기
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}
}
