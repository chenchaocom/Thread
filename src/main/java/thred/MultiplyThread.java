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

        FutureTask<String> futureTask = new FutureTask<String>(new MyThread3());

        Thread thread3 = new Thread(futureTask);
        thread3.start();
        System.out.println(futureTask.get());


    }
}

//继承Thread方式实现多线程
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": extend Thread方式实现多线程");
    }
}
//实现Runnable接口实现多线程
class MyThred2 implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+": implments Runnable方式实现多线程");
    }
}

//实现Callable接口实现多线程
 class MyThread3 implements Callable<String>{
    public String call() throws Exception {
        return Thread.currentThread().getName()+": implements Callable<> 方式实现多线程";
    }
}


