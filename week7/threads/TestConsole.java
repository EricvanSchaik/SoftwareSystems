package ss.week7.threads;

public class TestConsole extends Thread {
	
	public TestConsole() {
		this.start();
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		int sum1 = Console.readInt("get number 1?");
		int sum2 = Console.readInt("get number 2?");
		Console.println(getName() + ": " + sum1 + " + " + sum2 + " = " + (sum1+sum2));
	}
	
	public static void main(String[] args) {
		TestConsole test1 = new TestConsole();
		TestConsole test2 = new TestConsole();
	}

}
