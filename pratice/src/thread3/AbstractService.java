package thread3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:24 2019/5/25
 * @Modified By:
 */
public abstract class AbstractService implements Service{
    protected boolean started = false;
    //程序倒计时协调器
    protected final CountDownLatch latch;

    public AbstractService(CountDownLatch latch){
        this.latch = latch;
    }

    protected abstract void doStart() throws Exception;

    @Override
    public void start() {
        new ServiceStarter().start();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStart() {
        return started;
    }

    class ServiceStarter extends Thread{
        @Override
        public void run() {
            final String serviceName = AbstractService.this.getClass().getSimpleName();
            System.out.println("Service Name: "+ serviceName);

            try {
                doStart();
                started = true;
            } catch (Exception e) {
                started =false;
            } finally {
                //程序计数器减一
                latch.countDown();
                System.out.println("Done start "+serviceName);
            }
        }
    }
}
