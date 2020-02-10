package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPTimerClient {

	private static final String Server_IP = "127.0.0.1";
	private static final int Server_Port = 7000;
	private static final int BUFFER_SIZE = 7000;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null;
		try {
//				5.키보드 입력 받기
			scanner = new Scanner(System.in);

//				2. Socket 생성
			socket = new DatagramSocket();

			while (true) {
				System.out.println(">>");
				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					break;
				}
//					4.데이터 쓰기
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(Server_IP, Server_Port));
				socket.send(sendPacket);

//					5.데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // blocking

				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();

				String message = new String(data, 0, length, "UTF-8");

				System.out.println("[server] :" + message);

			}
		} catch (SocketException e) {

		} catch (IOException e) {

		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (socket != null && socket.isClosed()) {
				socket.close();
			}

		}

	}

}
