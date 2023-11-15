package q38;

public class Util {
    int ctr = 0;
    private static Util obj;
    private Util() {
        ++ctr;
    }
    static synchronized Util get() {
        if(obj == null)
            obj = new Util();
//        System.out.println(obj.ctr);
        return obj;
    }
}
