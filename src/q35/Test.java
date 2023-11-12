package q35;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String s1 = "LOCK1";
        String s2 = "LOCK2";
        List<String> list = new ArrayList<>();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    synchronized (s1) {
                        list.add("IN");
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (s1) {
                    synchronized (s2) {
                        list.add("OUT");
                    }
                }
            }
        };

        var es = Executors.newFixedThreadPool(4);
        es.submit(r2);
        es.submit(r1);
        es.shutdown();
        es.awaitTermination(2, TimeUnit.MILLISECONDS);
        System.out.println(String.join("-", list).isBlank() ? "BLANK" : String.join("-", list));
    }
}
