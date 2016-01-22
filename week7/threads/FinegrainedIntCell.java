package ss.week7.threads;

import java.util.concurrent.locks.*;

public class FinegrainedIntCell implements IntCell {
	
	private int value = 0;
	private Lock lock = new ReentrantLock();
	private Condition notRead = lock.newCondition();
	private Condition notWritten = lock.newCondition();
	
	public void setValue(int val) {
		lock.lock();
		try {
			value = val;
			notWritten.signal();
			notRead.await();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	
	public int getValue() {
		lock.lock();
		int val = 0;
		try {
			notWritten.await();
			val = value;
			notRead.signal();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		return val;
	}

}
