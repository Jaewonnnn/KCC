package kosa.io;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Dos {

	private File file;

	public Dos() {

	}

	public Dos(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void ls() {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				System.out.println((i + 1) + " : " + files[i].getName() + "(폴더)");
			} else {
				System.out.println((i + 1) + " : " + files[i].getName() + "(파일)");
			}
		}
	}

	public void cd(String name) {
		if (name.matches("^(cd) \\.\\.$")) {
			String[] newStr = file.getPath().split("\\\\");
			String newPath = "";
			for (int i = 0; i < newStr.length - 1; i++) {
				newPath += newStr[i];
				newPath += "\\";
			}
			setFile(new File(newPath));
		} else if (name.matches("^(cd) .*")) {
			String[] newStr = name.split(" ");
			setFile(new File(file.getPath() + "\\" + newStr[1]));
		}
	}

	public void mkdir(String menu) {
		if(menu.matches("^(mkdir) .*")){
			String[] newStr = menu.split(" ");
			new File(file.getPath(),newStr[1]).mkdirs();
		}
	}
	public void vi(String menu) {
		if(menu.matches("^(vi) .*\\..*")) {			
			FileWriter fw =null;
			String[] newStr = menu.split(" ");
			
			String str = "";
			String poem = "";
			Scanner sc = new Scanner(System.in);
			while(true) {
				
				str = sc.nextLine();
				if(str.equals(":q")) {
				break;
				}else {
					poem+=str;
					poem += "\n";
				}
			}
			try {
				fw = new FileWriter(file.getPath() +"\\\\"+ newStr[1]);
				fw.write(poem);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
