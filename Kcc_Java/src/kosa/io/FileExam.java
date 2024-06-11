package kosa.io;

import java.io.File;

public class FileExam {

	public static void show(File file) {
		File list[] = file.listFiles();
		for(int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				System.out.println();
				System.out.println("** " + list[i].getName() + " **");
				show(list[i]);
			}else {
				System.out.println("-" + list[i].getName());
			}
		}
	}
	
	public static void main(String[] args) {
		String path = "C:\\Users\\KOSA\\Desktop\\Java\\work\\java_work\\Kcc_Java";
		File file = new File(path);

		show(file);

	}
}