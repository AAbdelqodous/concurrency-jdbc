package q31;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        var es = Executors.newSingleThreadExecutor();
        var f1 = es.submit(() -> {}); // Future<?> submit(Runnable task)
        var f2 = es.submit(() -> 2); //<T> Future<T> submit(Callable<T> task)
        var f3 = es.submit(() -> {}, 3); // <T> Future<T> submit​(Runnable task, T result)
        System.out.println(f1.get(1, TimeUnit.HOURS));
        System.out.println(f2.get(2, TimeUnit.HOURS));
        System.out.println(f3.get(3, TimeUnit.HOURS));
        es.shutdown();
    }
}
