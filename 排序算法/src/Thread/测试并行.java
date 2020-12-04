package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ziyi.yuan
 * @date 2020/4/17 12:33 下午
 */
public class 测试并行 {
    public static void  async(){
        List<Long> longs = Arrays.asList(3000L,3500L,2000L,4000L,3800L);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    try {
                        Thread.sleep(longs.get(finalI));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return finalI * 10;
                }
            };
            Future<Integer> future = ThreadExecutorUtil.submitTask(task);
            list.add(future);
        }
        List<Integer> result  = new ArrayList<>();
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < list.size(); i++) {
                long time = System.currentTimeMillis();
                 int a = list.get(i).get();
                 result.add(a);
                System.out.println("finish time ={}"+(System.currentTimeMillis()-time));
            }

            System.out.println("total ="+(System.currentTimeMillis()-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        async();
    }
}
