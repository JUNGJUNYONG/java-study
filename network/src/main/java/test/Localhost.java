package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostname = inetAddress.getHostName();
			String hostaddres = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			System.out.println(Arrays.toString(addresses));
			
			for (byte addrsses : addresses) {
				System.out.print((addrsses & 0x000000ff)+" ");
			}
			System.out.println();
			
			System.out.println(hostname);
			System.out.println(hostaddres);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
