package q32;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player extends Thread{
    CyclicBarrier cb;

    public Player(){
        super();
    }

    public Player(CyclicBarrier cb) {
        this.cb = cb;
        this.start();  //p1 is already started in the constructor instead of es
    }

    public void run() {
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {}
    }
}
