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

/**
 * 1.继承Thread本质上也是实现Runnable接口。

 2.实现Callable接口的任务线程能返回执行结果，而实现Runnable接口的线程不能返回结果

 3.使用Callable的方式时候需要用FutureTask<>进行包装（适配），FutureTask实现了Runnable和Future，
 通过future里面的get()方法来得到返回值。需要注意的是get()方法是阻塞的，就是说取不到值会使主线程一直等待。
 */
//实现Callable接口实现多线程方式
 class MyThread3 implements Callable<String>{
    public String call() throws Exception {
        return Thread.currentThread().getName()+": implements Callable<> 方式实现多线程";
    }
}


