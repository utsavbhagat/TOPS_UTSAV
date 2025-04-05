package Module1_CoreJava;

//Synchronized Method

class Counter {
 private int count = 0;

 public synchronized void increment() {
     count++;
 }

 public synchronized int getCount() {
     return count;
 }
}

class CounterThread extends Thread {
 private Counter counter;

 public CounterThread(Counter counter) {
     this.counter = counter;
 }

 @Override
 public void run() {
     for (int i = 0; i < 20; i++) {
         counter.increment();
     }
 }
}

public class P034_ImplementThreadSynchronizationUsingSynchronizedBlocksOrMethods {
 public static void main(String[] args) throws InterruptedException {
     Counter counter = new Counter();
     CounterThread t1 = new CounterThread(counter);
     CounterThread t2 = new CounterThread(counter);
     CounterThread t3 = new CounterThread(counter);

     // Starting the threads
     t1.start();
     t2.start();
     t3.start();

  // Wait for threads to finish
     try {
         t1.join();
         t2.join();
         t3.join();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Display final count


     System.out.println("Final count: " + counter.getCount());
 }
}
