package q20;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Adder {
    private static final long LIMIT = 1000000000;
    private static final int THREADS = 100;

    static class AdderTask extends RecursiveTask<Long> {
        long from, to;

        public AdderTask(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= LIMIT/THREADS) {
                long localSum = 0;
                for(long i = from; i <= to; i++) {
                    localSum += i;
                }
                return localSum;
            }else{
                long mid = (from + to) / 2;
                AdderTask first = new AdderTask(from, mid);
                AdderTask second = new AdderTask(mid + 1, to);
                first.fork(); // to be executed on a separate thread
                //Insert
                return second.compute() + first.join(); // join what is forked not what is run ion a single thread --123639800 ns
//                return first.join() + second.compute(); // it takes more time - not utilized -- 229448900 ns
            }
        }
    }

    public static void main(String[] args) {
        LocalTime start = LocalTime.now();

        ForkJoinPool pool = new ForkJoinPool(THREADS);
        long sum = pool.invoke(new AdderTask(1, LIMIT));
        System.out.printf("sum of the number from %d to %d is %d %n", 1, LIMIT, sum);

        LocalTime end = LocalTime.now();
        System.out.println("It takes: " +ChronoUnit.NANOS.between(start, end) +" (Nano second)");
    }
}
