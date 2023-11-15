package q37;

import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        var s = Executors.newFixedThreadPool(1000);
        var a = new Accumulator();
        for(var i =1 ; i <= 1000; i++) {
            var x = i;
            s.execute(() -> a.accumulate(x));
        }
        s.shutdown();
        System.out.println(a.getList().size());
    }
}
