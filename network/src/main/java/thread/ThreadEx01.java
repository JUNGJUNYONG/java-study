package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
//		for (int i = 0; i <=10 ; i++) {
//			System.out.print(i);
//		}
		Thread digitalThread = new DigitalThread();
		digitalThread.start();
		System.out.println();
		for(char c= 'a'; c<='z';c++) {
			System.out.print(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
