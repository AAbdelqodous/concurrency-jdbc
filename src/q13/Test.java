package q13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var es = Executors.newFixedThreadPool(10);
        Future<?> future1 = es.submit(Test::print);
        Future<?> future2 = es.submit(Test::get);
        System.out.println(future1.get()); //return null if success
        System.out.println(future2.get());
        es.shutdown();
    }

    private static Integer get() {
        return 10;
    }

    private static void print() {
        System.out.println("PRINT");
    }
}
