package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UDPTimerServer {
	private static final int port = 7000;
	private static final int BUFFER_SIZE = 7000;

	public static String printDate(Calendar cal) {
		
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss a" );
		String data = format.format( new Date() );
		return data;

	}

	public static void main(String[] args) {
		Calendar cal = null;
		DatagramSocket socket = null;
		try {

//			1. socket 생성
			socket = new DatagramSocket(port);
			while (true) {
//			2. 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // blocking

				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				if (length == 0) {
					cal = Calendar.getInstance();
					byte[] sendData = printDate(cal).getBytes("UTF-8");
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
							receivePacket.getAddress(), receivePacket.getPort());
					socket.send(sendPacket);
					System.out.println("[return time]" + receivePacket.getAddress() + ":" + receivePacket.getPort());
				} else {

					String message = new String(data, 0, length, "UTF-8");

					System.out.println("[server] received:" + message);

//			3. 데이터 송신
					byte[] sendData = message.getBytes("UTF-8");
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
							receivePacket.getAddress(), receivePacket.getPort());
					socket.send(sendPacket);
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}

	}
}
