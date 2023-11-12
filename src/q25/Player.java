package q25;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Player extends Thread{
    CyclicBarrier cb;
    public Player(CyclicBarrier cb) {
        this.cb = cb;
    }

    public void run() {
        try {
            cb.await(); // hold the thread until 3 parties completed (3 threads)
//            cb.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | BrokenBarrierException e) {}
    }
}
