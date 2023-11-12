package q34;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        var cb = new CyclicBarrier(6, () -> System.out.println("HURRAH!"));
        var es = Executors.newFixedThreadPool(5);
        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(x -> es.submit(() -> cb.await())); // 6 threads must call await()
        es.shutdown();
    }
}
