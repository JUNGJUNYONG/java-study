package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	List<PrintWriter> list2Writers = new ArrayList<PrintWriter>();
	List<PrintWriter> listWriters;
	List<String> listWriters1;
	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;
	int temp = 0;
	int temp2 = 0;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters, List<String> listWriters1) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.listWriters1 = listWriters1;
	}

	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		/* writer pool에 저장 */
		addWriter(writer);

		// ack
		printWriter.println("join:ok");
		printWriter.flush();
	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);

		}
	}

	private void doMessage(String message) {
		broadcast(nickname + ":" + message);
	}

	private void toMessage(String data, int a, int b) {
		synchronized (list2Writers) {
			list2Writers.add(listWriters.get(a));
			list2Writers.add(listWriters.get(b));
		}
		for (int i = 0; i < list2Writers.size(); i++) {
			list2Writers.get(i).println(nickname + ":" + data);
		}
		list2Writers.clear();
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}

		}
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}
	
	private void randomKick(int i) {
		String data = listWriters1.get(i)+"!.!님이 랜덤으로 강퇴 당하셨습니다.";
		broadcast(data);
		listWriters.remove(i);
		listWriters1.remove(i);
		
	}

	private void removeWriter(PrintWriter writer) {
		listWriters.remove(writer);
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		try {

//			4. IOStream 받아오기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			while (true) {
//			5. 데이터 읽기
				String request = bufferedReader.readLine();
				if (request == null) {
					log("클라이언트로 부터 연결 끊김");
					break;
				}
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
					listWriters1.add(tokens[1]);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else if ("kick".equals(tokens[0])) {
					int i = (int)Math.random()*listWriters1.size();
					randomKick(i);
				} else if ("to".equals(tokens[0])) {
					for (int i = 0; i < listWriters1.size(); i++) {
						if (tokens[1].equals(listWriters1.get(i))) {
							temp = i;
						}
						if (tokens[2].equals(listWriters1.get(i))) {
							temp2 = i;
						}
					}
					toMessage(tokens[3], temp, temp2);

				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

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
	}

	public static void log(String log) {
		System.out.println("[server]" + Thread.currentThread().getId() + log);

	}

}
