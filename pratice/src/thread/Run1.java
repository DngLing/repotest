package thread;

import java.util.concurrent.*;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 18:53 2019/5/23
 * @Modified By:
 */
public class Run1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        //开启线程
        Future<Integer> integerFuture = executor.submit(task);
        try {
            System.out.println("阻塞主线程");
            Thread.sleep(1000);
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程执行完毕");
        try {
            //这里会阻塞线程,在task执行完后才会
            System.out.println("task 运行结果"+integerFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务指向完毕");
        System.out.println("线程是否完成？ "+ integerFuture.isDone());
        System.out.println("线程是否被取消过？ "+ integerFuture.isCancelled());
    }
}
