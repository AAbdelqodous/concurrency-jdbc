package q33;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tour {
    CyclicBarrier cb;

    Tour(CyclicBarrier cb) {
        this.cb = cb;
        try {
            cb.await();
        } catch(InterruptedException | BrokenBarrierException e) {}
    }
}
