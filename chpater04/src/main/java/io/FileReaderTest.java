package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String args[]) {
		Reader in = null;
		InputStream is = null;

		try {
			in = new FileReader("1234.txt");
			int count = 0;
			int data = -1;
			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println();
			System.out.println(count);
			System.out.println("============================");

			count = 0;
			data = -1;
			is = new FileInputStream("1234.txt");
			while ((data = is.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println();
			System.out.println(count);
			System.out.println("============================");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다 - " + e);
		} catch (IOException e) {
			System.out.println("에러 - " + e);

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if(is != null) {
				try {
					is.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
