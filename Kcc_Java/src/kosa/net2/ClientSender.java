package kosa.net2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSender extends Thread{
	private Socket socket;

	public ClientSender() {
		// TODO Auto-generated constructor stub
	}

	public ClientSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String str = br.readLine();
				if(str.equals("bye")) break;
				writer.println(str);
				writer.flush(); // 버퍼 비우기
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
