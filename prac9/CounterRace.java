class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}

public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final Count: " + counter.count);
        System.out.println("Expected Count: 1000000");
    }
}