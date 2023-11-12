package q33;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {
        var cb = new CyclicBarrier(2, () -> System.out.println("START...")); //Line n1

        cb.await(10000, TimeUnit.MILLISECONDS); //Line n2

        var tour = new Tour(cb); //Line n3
        var tour1 = new Tour(cb); //Line n3

        System.out.println("END..."); //Line n4
    }
}
