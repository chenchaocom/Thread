package thred.threadgroup;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenchao on 2019/7/20.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        /**
         * 构造方法的参数及意义：

         corePoolSize：核心线程池的大小，如果核心线程池有空闲位置，这是新的任务就会被核心线程池新建一个线程执行，
         执行完毕后不会销毁线程，线程会进入缓存队列等待再次被运行。

         maximunPoolSize：线程池能创建最大的线程数量。如果核心线程池和缓存队列都已经满了，新的任务进来就会创建新
         的线程来执行。但是数量不能超过maximunPoolSize，否侧会采取拒绝接受任务策略，我们下面会具体分析。

         keepAliveTime：非核心线程能够空闲的最长时间，超过时间，线程终止。这个参数默认只有在线程数量超过核心线程
         池大小时才会起作用。只要线程数量不超过核心线程大小，就不会起作用。

         unit：时间单位，和keepAliveTime配合使用。

         workQueue：缓存队列，用来存放等待被执行的任务。

         threadFactory：线程工厂，用来创建线程，一般有三种选择策略。
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor
                (5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0;i<200;i++){
            Task task = new Task(i);
            pool.execute(task);
            System.out.println("线程池的线程数目"+pool.getPoolSize()+",线程池中等待的数目"+
            pool.getQueue().size()+",线程完成的数目"+pool.getCompletedTaskCount());
        }

        pool.isTerminated();

    }
}
