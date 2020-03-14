import java.util.concurrent.TimeUnit;
public class Main {

    public static void main(String[] args) {
        int[] testSizes = {1, 200, 3000, 40000, 500000, 6000000};
        boolean displaySwitch = true; //boolean determines if the faster algorithim is current test subject
        String name;
        
        //populate the testarray
        for(int i = 0; i < testSizes.length; i++) {
        	Integer[] items = new Integer[testSizes[i]];
        	for(int k = 0; k < items.length; k++) {
        		//ascending order, so slowest case for effective testing
        		items[k] = k;
        	}
        	MaxHeap subject = new MaxHeap(items.length);
        	long startTime = System.nanoTime();
        	//switch to test certain algorithm
        	if(displaySwitch) {
        		subject.MaxHeapN(items); name = "O(n)";
        	}else {
        		subject.MaxHeapLogN(items); name = "O(LogN)";
        	}
        	long endTime = System.nanoTime();
        	long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
            System.out.println(name + " Tested at Size: " + testSizes[i] + ", milliseconds: " + durationInMillis);
        }
    }
}
