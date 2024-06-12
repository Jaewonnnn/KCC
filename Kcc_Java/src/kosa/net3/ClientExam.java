package kosa.net3;

import java.net.Socket;

public class ClientExam {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.0.249", 9000);
			
			Thread receive = new ClientReceive(socket);
			Thread sender = new ClientSender(socket);
			
			receive.start();
			sender.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//socket.close();
			} catch (Exception e2) {}
		}

	}

}







