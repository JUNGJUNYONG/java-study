package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
//			1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
//			1.1 Time-wait 시간에 소켓에 포트번호 할당을 가능하게 하기 위해서
			serverSocket.setReuseAddress(true); //필수
			

//			2. 바인딩: socket Address(IP Address + port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));

//			3. accept
			Socket socket = serverSocket.accept();// blocking
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server]connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			try {
//			4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while (true) {
//			5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);
					if (readByteCount == -1) {
//				client에서 정상종료
						System.out.println("[server]close by client");
						break;
					}
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server]received:" + data);
//				6.데이터쓰기
					os.write(data.getBytes("UTF-8"));
					
				}

			} catch (SocketException e) {
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
				}

			}

		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
