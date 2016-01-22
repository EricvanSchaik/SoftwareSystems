package ss.week7.account;

import java.util.concurrent.locks.*;

public class Account {
	
	protected double balance = 0.0;
	private Lock lock = new ReentrantLock();
	private Condition tooNegative = lock.newCondition();

	synchronized public void transaction(double amount) {
		lock.lock();
		try {
			if (balance + amount < -1000) {
				tooNegative.await();
			}
			if (amount > 0) {
				balance = balance + amount;
				tooNegative.signal();
			}
			else {
				balance = balance + amount;
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public double getBalance() {
		return balance;
	}
}
