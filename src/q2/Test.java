package q2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> r = () -> {
            int sum = 0;
            for(int i = 1; i < 1000; i++) {
                sum += i / new Random().nextInt(50);
            }
            return "" + sum;
        };

        var es = Executors.newSingleThreadExecutor();
        var f = es.submit(r);
        System.out.println(f.get()); //Line n1
        es.shutdown();
    }
}
