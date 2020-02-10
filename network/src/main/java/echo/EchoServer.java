package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private final static int SERVER_PORT = 5000;
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
//		1. 서버소켓 생성
		serverSocket = new ServerSocket();

//		2. 바인딩: socket Address(IP Address + port) Binding
		serverSocket.bind(new InetSocketAddress("127.0.0.1", SERVER_PORT)); //계속 작동해야됨

//		3. accept
		while(true) {
			Socket socket = serverSocket.accept();
			new EchoServerRecevieThread(socket).start();
		}
//		Socket socket = serverSocket.accept();// blocking
		}catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {if(serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void log (String log) {
		System.out.println("[server]"+Thread.currentThread().getId()+log);
	}
}

