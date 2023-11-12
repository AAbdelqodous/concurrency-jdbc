package q25;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        var match = new Match();
        var cb = new CyclicBarrier(2, match);
        var es = Executors.newFixedThreadPool(2); //DeadLock: No of threads less than no. of parties of CyclicBarrier
        es.execute(new Player(cb)); // also you must have enough tasks(Player instances) - 1st bulk
        es.execute(new Player(cb)); //  - 1st bulk
        es.execute(new Player(cb)); // 2nd bulk
        es.execute(new Player(cb)); // 2nd bulk
        es.shutdown();
    }
}
