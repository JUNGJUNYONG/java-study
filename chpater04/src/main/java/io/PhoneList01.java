package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			
		File file = new File("phone.txt");
		
		if(!file.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		}
		System.out.println("=============================파일정보===========================");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length()+"bytes");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
		
		System.out.println("=============================전화번호=========================");
//		기반스트림(byte)
		FileInputStream fis = new FileInputStream(file);
//		보조스트림(byte -> char)
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
//		보조스트림 라인입력
		br = new BufferedReader(isr);
//		처리
		String line = null;
		while((line = br.readLine())!= null) {
			StringTokenizer st = new StringTokenizer(line,"\t ");
			int index = 0;
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
//				System.out.println(token);
				if(index ==0) {//이름
					System.out.print(token+":");
				}else if(index ==1){//전화번호1
					System.out.print(token+"-");
				}else if(index ==2) {
					System.out.print(token+"-");
				}else {
					System.out.println(token);
				}
				index++;
			}
		
		}
		
		} catch (IOException e) {
			System.out.println("error:"+e);
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
