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
         * ���췽���Ĳ��������壺

         corePoolSize�������̳߳صĴ�С����������̳߳��п���λ�ã������µ�����ͻᱻ�����̳߳��½�һ���߳�ִ�У�
         ִ����Ϻ󲻻������̣߳��̻߳���뻺����еȴ��ٴα����С�

         maximunPoolSize���̳߳��ܴ��������߳���������������̳߳غͻ�����ж��Ѿ����ˣ��µ���������ͻᴴ����
         ���߳���ִ�С������������ܳ���maximunPoolSize�������ȡ�ܾ�����������ԣ������������������

         keepAliveTime���Ǻ����߳��ܹ����е��ʱ�䣬����ʱ�䣬�߳���ֹ���������Ĭ��ֻ�����߳��������������߳�
         �ش�Сʱ�Ż������á�ֻҪ�߳����������������̴߳�С���Ͳ��������á�

         unit��ʱ�䵥λ����keepAliveTime���ʹ�á�

         workQueue��������У�������ŵȴ���ִ�е�����

         threadFactory���̹߳��������������̣߳�һ��������ѡ����ԡ�
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor
                (5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0;i<200;i++){
            Task task = new Task(i);
            pool.execute(task);
            System.out.println("�̳߳ص��߳���Ŀ"+pool.getPoolSize()+",�̳߳��еȴ�����Ŀ"+
            pool.getQueue().size()+",�߳���ɵ���Ŀ"+pool.getCompletedTaskCount());
        }

        pool.isTerminated();

    }
}
