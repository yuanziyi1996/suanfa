import java.util.Vector;

public class Ab {
    public static void main(String[] args) {
        System.out.println(f(7,3));

    }
    public static int f(int n, int m) {
        n = n % m;
        Vector<Integer> v = new Vector<Integer>();

        for (; ; ) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0)
                return 0;
            if (v.indexOf(n) >= 0)
                return  v.size()-v.indexOf(n); //填空
        }

    }
}
