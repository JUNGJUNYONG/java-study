package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
//		기반스트림
		try {
			FileReader fr = new FileReader("./src/io/BufferedReaderTest.java");
			br = new BufferedReader(fr);
			
			int index = 0;
			String line = null;
			while((line = br.readLine()) != null) {
				index++;
				System.out.print(index);
				System.out.print(":");
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다. - " + e);
		} catch(IOException e){
			System.out.println(e);
		}
		finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
