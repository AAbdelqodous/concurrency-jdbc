package q32;

import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        var match = new Match();
        var cb = new CyclicBarrier(2, match); // means 2 threads must call await() so that Cyclic Barrier is
        // tripped and barrier action is executed,
        var p1 = new Player(cb); // assigns passed CyclicBarrier instance to 'cb' property of the Player
        // and it also invokes start() method so that this Player thread becomes Runnable.
        //p1 is already started in the constructor
        new Player(cb);
    }
}
