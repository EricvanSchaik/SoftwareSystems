package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		Account account = new Account();
		MyThread mythread1 = new MyThread(100, 100, account);
		MyThread mythread2 = new MyThread(-100, 100, account);
		mythread1.start();
		mythread2.start();
		System.out.println(account.getBalance());
	}

}
