package kosa.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyUtil {
	
	//디렉토리 복사(해당 폴더 복사해서 새로운 디렉토리를 생성 후 모든 파일을 복사)
	public static void copyDirectory(File source, File dest) {
		if(source.isDirectory()) {
			dest.mkdirs();

			File fileList[] = source.listFiles();
			for(int i = 0; i < fileList.length; i++) {
				File sourceFile = fileList[i];
				if(sourceFile.isDirectory()) {
					//재귀
					//new File(해당하는 디렉토리 경로, 파일 이름);
					copyDirectory(sourceFile, new File(dest, sourceFile.getName()));
				}else {
					copyFile(sourceFile, new File(dest, sourceFile.getName()));
				}
			}
		}
	}
	
	// 바이트 값을 가진 파일 1개를 복사하는 메서드
	public static void copyFile(File source, File dest) { // source원본 dest
		FileInputStream fr = null;
		FileOutputStream fw = null;
		byte arr[] = new byte[1024];
		int data = 0;

//		try {
//			fr = new FileInputStream(source);
//			fw = new FileOutputStream(dest);
//			fw.write(fr.readAllBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				fw.close();
//				fr.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}

		try {
			fr = new FileInputStream(source);
			fw = new FileOutputStream(dest);
			while ((data = fr.read(arr)) != -1) {
				fw.write(arr, 0, data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}