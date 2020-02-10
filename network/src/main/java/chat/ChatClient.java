package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private final static String SERVER_IP = "127.0.0.1";
	private final static int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결1. Scanner 생성(표준입력, 키보드연결)
			scanner = new Scanner(System.in);

//			2. Socket 생성
			socket = new Socket();

//			3.서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 4. reader/writer 생성

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				String [] a = input.split("/");
				if ("quit".equals(input) == true) {
					pw.println("quit");
					// 8. quit 프로토콜 처리
					break;
				} else if (input.isEmpty()) {
					System.out.println("글자입력해줘");
				} else if ("to".equals(a[0])) {
					if(!a[1].isEmpty()) {
						if(!a[2].isEmpty()) {
					pw.println("to:"+nickname+":"+a[1]+":"+a[2]);
						}
					}
				}else {
					pw.println("message:" + input);
				}
			}

		} catch (IOException ex) {

		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
