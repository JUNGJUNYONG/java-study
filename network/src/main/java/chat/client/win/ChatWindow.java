package chat.client.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private PrintWriter pw = null;
	private BufferedReader br = null;
	private String name;
	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.name = name;
	}
	public void show() {
		/**
		 * 1. UI초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/**
		 * 2. IOStream 초기화
		 */

		/**
		 * 3. 쓰레드 생성 작업
		 */
		new ChatClientThread().start();
	}

	private void sendMessage() {
		String message = textField.getText();
		String [] temp = message.split("/");
		textField.setText("");
		textField.requestFocus();
		if(temp[0].equals("to")) {
			if(!temp[1].isEmpty()) {
				if(!temp[2].isEmpty()) {
					pw.println("to:"+this.name+":"+temp[1]+":"+temp[2]);
				}
			}
		}else if(message.equals("kick")) {
			pw.println("kick:");
		}
		else if(!message.equals("")) {
		pw.println("message:" + message);
		}else if(message.equals("quit")) {
			pw.println("quit");
			System.exit(0);
		}
	}

	public class ChatClientThread extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					String readMessage = br.readLine();
					String []temp = readMessage.split("!.!");
					if(temp[0].equals(name)) {
						textArea.append("강퇴당하셨습니다.");
						System.exit(3);
					}else {
					textArea.append(readMessage + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
