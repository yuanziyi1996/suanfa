package 异常;

public class finally中return {

    public static int test(){
        int i = 1;
        try {
            System.out.println("进入 try" + i);
            i=i+5;
            System.out.println(" try 中 i=" + i );
            System.out.println(" try 中 当前线程 "+Thread.currentThread().getName());
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("进入 finally " + i);
            i++;
            System.out.println(" finally 中 当前线程 "+Thread.currentThread().getName());
            //如果finally 中有return 最终返回的是finally 、
            //finally 中没有return，则 返回的是try 中的，而且在 finally中修改的i值在try中没有用。
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("result : " +test());
    }


}
