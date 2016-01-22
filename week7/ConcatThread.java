package ss.week7;

import java.util.concurrent.locks.*;

public class ConcatThread extends Thread {
    
	private static String text = ""; // global variable
    private String toe;
    private Lock lock = new ReentrantLock();
    private Condition hasconcat = lock.newCondition();
    private boolean isBusy = false;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public void run() {
    	text = text.concat(toe);
    }

    public static void main(String[] args) {
        (new ConcatThread("one;")).start();
        try {
        	sleep(100);
        }
        catch (InterruptedException e) {
        	e.printStackTrace();
        }
        (new ConcatThread("two;")).start();
        try {
        	sleep(100);
        }
        catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println(text);
    }
}
