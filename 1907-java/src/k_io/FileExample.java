package k_io;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));
		
		if(!dir.exists()) { dir.mkdirs();}
		if(!file1.exists()) { file1.createNewFile();}
		if(!file2.exists()) { file2.createNewFile();}
		if(!file3.exists()) { file3.createNewFile();}
		
		File temp = new File("C:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a HH:mm");
		File[] contents = temp.listFiles();
		
		System.out.println("날짜                시간              형태                크기            이름");
		for(File ne : contents) {
			System.out.print(sdf.format(new Date(ne.lastModified())));
			if(ne.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t "+ne.getName());
			}else {
				System.out.println("\t\t\t" + ne.length() + "\t" + ne.getName());
			}
			System.out.println();
		}
	}
}
