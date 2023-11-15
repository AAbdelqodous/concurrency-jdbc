package q38;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        var es = Executors.newFixedThreadPool(100);
        IntStream.rangeClosed(1, 10000)
                .parallel()
                .forEach(x -> es.submit(() -> Util.get()));
        es.shutdown();

    }
}
