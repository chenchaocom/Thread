package thred;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by chenchao on 2019/7/20.
 */
public class MultiplyThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        Thread myThred2 = new Thread(new MyThred2());
        myThred2.start();

        FutureTask<String> stringFutureTask = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                return "aa";
            }
        });


        Thread thread3 = new Thread(stringFutureTask);
        thread3.start();
        System.out.println(stringFutureTask.get());


    }
}

//�̳�Thread��ʽʵ�ֶ��߳�
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": extend Thread��ʽʵ�ֶ��߳�");
    }
}
//ʵ��Runnable�ӿ�ʵ�ֶ��߳�
class MyThred2 implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+": implments Runnable��ʽʵ�ֶ��߳�");
    }
}

/**
 * 1.�̳�Thread������Ҳ��ʵ��Runnable�ӿڡ�

 2.ʵ��Callable�ӿڵ������߳��ܷ���ִ�н������ʵ��Runnable�ӿڵ��̲߳��ܷ��ؽ��

 3.ʹ��Callable�ķ�ʽʱ����Ҫ��FutureTask<>���а�װ�����䣩��FutureTaskʵ����Runnable��Future��
 ͨ��future�����get()�������õ�����ֵ����Ҫע�����get()�����������ģ�����˵ȡ����ֵ��ʹ���߳�һֱ�ȴ���
 */
//ʵ��Callable�ӿ�ʵ�ֶ��̷߳�ʽ
 class MyThread3 implements Callable<String>{
    public String call() throws Exception {
        return Thread.currentThread().getName()+": implements Callable<> ��ʽʵ�ֶ��߳�";
    }
}


