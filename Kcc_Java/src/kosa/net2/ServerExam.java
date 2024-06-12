package kosa.net2;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			System.out.println("서버 실행중!");

			socket = serverSocket.accept();
			
			Thread receive = new ServerReceive(socket);
			Thread sender = new ServerSender(socket);
			
			receive.start();
			sender.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
