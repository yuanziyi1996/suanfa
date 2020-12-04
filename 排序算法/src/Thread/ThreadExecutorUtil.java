package Thread;

import java.util.concurrent.*;

/**
 * @author ziyi.yuan
 * @date 2020/4/15 2:17 下午
 */
public class ThreadExecutorUtil {


    /**
     * 线程池维护线程的最大数量
     */
    private final static int MAX_SIZE = 100;

    /**
     * 线程池最少存活数量 (核心数量)
     */
    private final static int CORE_SIZE = 50;

    /**
     * 空闲线程最大存活时间
     */
    private final static long KEEP_ALIVE = 1000L;
    private final static TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    /**
     * 使用基于双向链表的阻塞队列，对排队的任务数量没有限制
     */
    private final static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue();


    public static final ExecutorService executorService = new ThreadPoolExecutor(CORE_SIZE,
            MAX_SIZE, KEEP_ALIVE, TIME_UNIT, QUEUE);

    public static void executeTask(Runnable task) {
        executorService.execute(task);
    }

    public static Future submitTask(Callable callable) {
        return executorService.submit(callable);
    }

}
