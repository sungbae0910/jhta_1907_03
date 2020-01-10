package z_exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx {
	
	/*/
	 * public : 모든 곳
	 * protected : 같은패키지, 상속관계
	 * default : 같은패키지
	 * private : 같은 클래스  
	 */
	public FileStreamEx() {
		try {
			File file = new File("abc.png");
			FileInputStream readFile = new FileInputStream(file);
			
			File file2 = new File("def.png");
			FileOutputStream fos = new FileOutputStream(file2);
			
			byte[] readByte = new byte[4096]; //4kb
			int readSize = 0;
			
			try {
				while( (readSize = readFile.read(readByte))!=-1) {
					fos.write(readByte, 0, readSize);
				}
				fos.flush();
				fos.close();
				readFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileStreamEx fse = new FileStreamEx();
		
	}
}
