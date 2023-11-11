package q11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var es = Executors.newSingleThreadExecutor();
//        Future<String> f = es.execute(() -> "HELLO"); execute(Runnable), Runnable =>v oid run()
        es.execute(() -> System.out.println(Thread.currentThread().getName() +"HELLO"));
//        System.out.println(f.get());
        es.shutdown();
    }
}
