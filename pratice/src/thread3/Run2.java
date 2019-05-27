package thread3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:53 2019/5/25
 * @Modified By:
 */
public class Run2 {
    private static final CountDownLatch la = new CountDownLatch(4);
    private static int data = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    la.countDown();
                    data++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(runnable).start();
        try {
            //在线程执行四次后，主线程会在此处被唤醒，此时的data=4
            la.await();
            //但如果我们在等一会儿 Thread.sleep(6000) 此时data = 9;
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
