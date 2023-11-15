package q37;

import java.util.ArrayList;
import java.util.List;

public class Accumulator {
    private List<Integer> list = new ArrayList<>();

    public synchronized void accumulate(int i) {
        list.add(i);
    }

    public List<Integer> getList() {
        return list;
    }
}
