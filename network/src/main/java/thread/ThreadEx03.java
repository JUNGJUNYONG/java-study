package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UppercaseAlpaberRunnableImpl());
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
