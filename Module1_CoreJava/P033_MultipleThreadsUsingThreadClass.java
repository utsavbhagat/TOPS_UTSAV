package Module1_CoreJava;

class MyThread extends Thread {
    private String threadName;

    // Constructor to pass the thread name
    public MyThread(String name) {
        this.threadName = name;
    }

    // Override the run() method to define what each thread will do
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running: " + i);
            try {
                // Adding sleep to simulate some work
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}

public class P033_MultipleThreadsUsingThreadClass {
	public static void main(String[] args) {
        // Step 2: Create multiple threads
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        MyThread thread3 = new MyThread("Thread-3");

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for all threads to finish before exiting the main method
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
        System.out.println("All threads have finished execution.");
    }
}

