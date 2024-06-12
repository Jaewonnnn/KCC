package kosa.net1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerExam {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket client = null;
		try {
			serverSocket = new ServerSocket(9000);
			
			System.out.println("서버 실행 중......");
			client = serverSocket.accept(); // 클라이언트 소켓 accept
			
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			byte[] arr = new byte[100];
			in.read(arr); //arr의 크기만큼 읽음
			
			System.out.println("클라이언트가 보낸 메시지 : " + new String(arr));
			
			String message = "Hello client!!!";
			out.write(message.getBytes()); // getBytes -> string to byte array
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				client.close();
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

}
