package thred.threadgroup;

/**
 * Created by chenchao on 2019/7/20.
 */
public class Task implements Runnable{

    private int num;

    public Task(int num){
        this.num = num;
    }

    public void run() {
        System.out.println("正在执行任务 "+num);
        try {
            Thread.currentThread().sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+num+"执行完毕");
    }
}
