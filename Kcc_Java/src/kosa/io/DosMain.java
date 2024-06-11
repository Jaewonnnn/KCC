package kosa.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DosMain {

	public static void main(String[] args) throws IOException{

		Dos dos = new Dos(new File("C:\\Users\\KOSA\\Desktop"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menu = "";
		while(true) {
			System.out.print(dos.getFile().getPath() + "\\> ");
			menu = br.readLine();
			if(menu.equals("ls")) {
				dos.ls();
			}else if(menu.contains("cd")) {
				dos.cd(menu);
			}else if(menu.contains("mkdir")) {
				dos.mkdir(menu);
			}else if(menu.contains("vi")) {
				dos.vi(menu);
			}else if(menu.equals("q")){
				System.out.println("종료");
				break;
			}
		}
		
		
	}

}
