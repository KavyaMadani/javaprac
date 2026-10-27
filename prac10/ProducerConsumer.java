class Buffer {
    private int number;
    private boolean available = false;

    synchronized void produce(int n) throws InterruptedException {
        while (available) {
            wait();
        }

        number = n;
        available = true;

        System.out.println("Produced: " + number);
        notify();
    }

    synchronized void consume() throws InterruptedException {
        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + number);
        available = false;

        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}