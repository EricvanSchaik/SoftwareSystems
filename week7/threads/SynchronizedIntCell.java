package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	
	private int value = 0;
	private boolean hasbeenread = true;

	synchronized public void setValue(int valueArg) {
		try {
			if (!hasbeenread) {
				wait();
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		this.value = valueArg;
		hasbeenread = false;
		notify();
	}

	synchronized public int getValue() {
		try {
			if (hasbeenread) {
				wait();
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		hasbeenread = true;
		notify();
		return value;
	}
}
