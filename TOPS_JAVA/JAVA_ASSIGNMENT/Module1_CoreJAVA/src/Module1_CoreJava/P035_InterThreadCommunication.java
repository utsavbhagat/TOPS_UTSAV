package Module1_CoreJava;

class SharedBuffer {
    private int buffer = -1;  // -1 indicates empty buffer
    private boolean isEmpty = true;

    // Produce an item (Producer)
    public synchronized void produce(int item) {
        while (!isEmpty) {
            try {
                // Wait if the buffer is full
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        // Produce the item (add to the buffer)
        buffer = item;
        isEmpty = false;
        System.out.println("Produced: " + item);

        // Notify the consumer that the buffer has an item
        notify();
    }

    // Consume an item (Consumer)
    public synchronized void consume() {
        while (isEmpty) {
            try {
                // Wait if the buffer is empty
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        // Consume the item (remove from the buffer)
        System.out.println("Consumed: " + buffer);
        isEmpty = true;

        // Notify the producer that the buffer is empty
        notify();
    }
}

// Producer Thread
class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);  // Produce item
            try {
                Thread.sleep(1000);  // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();  // Consume item
            try {
                Thread.sleep(2000);  // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class P035_InterThreadCommunication {
	public static void main(String[] args) {
        // Create the shared buffer object  
        SharedBuffer sharedBuffer = new SharedBuffer();

        // Create the producer and consumer threads
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);

        // Start the threads
        producer.start();
        consumer.start();
    }
}
