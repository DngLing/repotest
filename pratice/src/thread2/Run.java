package thread2;

import thread2.Task;

import java.util.concurrent.*;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 19:24 2019/5/23
 * @Modified By:
 */
public class Run {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = (FutureTask<Integer>) executor.submit(task);
        //由于FuturnTask 实现了RunnableFuture<V> 的接口, 而RunableFuture继承了Runnable和Future的接口,
        //所以，FutureTask既能以Future一样得到Callable的 返回值，又能像Runable被线程执行。
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println("主函数执行结束");

        //
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主进程执行任务中");

        try {
            System.out.println(futureTask.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
        executor.shutdown();
    }
}
