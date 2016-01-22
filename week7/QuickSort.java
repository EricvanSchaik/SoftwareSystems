package ss.week7;

import java.util.concurrent.*;

public class QuickSort extends Thread {
	
	private int[] array;
	private int first = 0;
	private int last;
	
	public QuickSort(int[] array, int first, int last) {
		this.array = array;
		this.first = first;
		this.last = last;
	}
	
    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            QuickSort q1 = new QuickSort(a, first, position - 1);
            q1.start();
            QuickSort q2 = new QuickSort(a, position + 1, last);
            q2.start();
            try {
            	q1.join();
            	q2.join();
            }
            catch (Exception e) {
            	e.printStackTrace();
            }
        }
    }
    
    public static int partition(int[] a, int first, int last) {
    	
        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public void run() {
    	qsort(array, first, last);
    }

}
