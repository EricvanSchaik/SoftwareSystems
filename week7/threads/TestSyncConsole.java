package ss.week7.threads;

import java.util.concurrent.locks.*;

public class TestSyncConsole extends Thread {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public TestSyncConsole() {
		this.start();
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		lock.lock();
		try {
			int sum1 = SyncConsole.readInt("get number 1?");
			int sum2 = SyncConsole.readInt("get number 2?");
			SyncConsole.println(getName() + ": " + sum1 + " + " + sum2 + " = " + (sum1+sum2));
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public synchronized static void main(String[] args) {
		new TestSyncConsole();
		new TestSyncConsole();
	}

	
	
	
}
