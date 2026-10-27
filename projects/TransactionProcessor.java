import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TransactionProcessor {

    ExecutorService pool = Executors.newFixedThreadPool(4);

    void submit(Runnable task) {
        pool.execute(task);
    }

    void stop() {
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}