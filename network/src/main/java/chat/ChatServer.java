package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private final static int SERVER_PORT = 5000;
	static List<PrintWriter> listWriters = new ArrayList<PrintWriter>(); 
	static List<String> listWriters1 = new ArrayList<String>(); 
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
//		1. 서버소켓 생성
			serverSocket = new ServerSocket();

//		2. 바인딩: socket Address(IP Address + port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1", SERVER_PORT)); // 계속 작동해야됨
//		3. accept
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters,listWriters1).start(); // 데이터를 받고 처리하는 부분
			}

//		Socket socket = serverSocket.accept();// blocking
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	


	public static void log(String log) {
		System.out.println("[server]" + Thread.currentThread().getId() + log);

	}

}
