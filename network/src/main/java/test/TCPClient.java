package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
//			1.소켓 생성
			socket = new Socket();

//			1-1. 소켓 버퍼 사이즈 확인
			int reciveBufferSize = socket.getReceiveBufferSize();
			int sendbufferSize = socket.getSendBufferSize();
			System.out.println((reciveBufferSize + ":" + sendbufferSize));

//			1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);

//			1-3. SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);
			
//			1-4. 데이터 읽기에 타임아웃 설정
			socket.setSoTimeout(1000);
			
			System.out.println((reciveBufferSize + ":" + sendbufferSize));

//			2.서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("connected");
//			3. IO스트림
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
//			4. 쓰기
			String data = "Hello World\n";
			os.write(data.getBytes("UTF-8"));

//			5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
//				client에서 정상종료
				System.out.println("close by client");
				return;
			}

			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client]received:" + data);

		} catch (SocketTimeoutException e) {
			System.out.println("[clinet] time out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
