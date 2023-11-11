package q5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Test {
    private void increment(int start, int end) throws InterruptedException, ExecutionException {
        var es = Executors.newFixedThreadPool(10);
        var results = new Future<?>[26];
        IntStream.rangeClosed(start, end)
                .parallel()
//                .peek(System.out::println)
                .forEach(x -> results[x] = es.submit(() -> new String(new char[]{(char)(x + 65)})));
        System.out.println(results[1].get());
        /* for (int i = 0; i < results.length; i++) {
            System.out.println(results[i].get());
        } */

        es.shutdown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Test().increment(0, 25);
    }
}
