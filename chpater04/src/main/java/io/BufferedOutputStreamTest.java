package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
//			기반스트림(소스에 연결)
			FileOutputStream fis = new FileOutputStream("test.txt");
//			보조스트림(기반스트림 또는 보조스트림에 연결)
			bos = new BufferedOutputStream(fis);

			for (int i = 'a'; i <= 'z'; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열수 없습니다." + e);
		} catch (IOException e) {
			System.out.println("err" + e);
		}

		finally {
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
