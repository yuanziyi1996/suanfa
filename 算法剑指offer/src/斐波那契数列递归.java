public class 斐波那契数列递归 {
    public static int fab(int n){
        if(n==1||n==2)
            return n;
        else
            return fab(n-1)+fab(n-2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fab(46));
        System.out.println(System.currentTimeMillis()-start);

    }
}
