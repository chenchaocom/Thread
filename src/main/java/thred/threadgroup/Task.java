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
        System.out.println("����ִ������ "+num);
        try {
            Thread.currentThread().sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�߳�"+num+"ִ�����");
    }
}
