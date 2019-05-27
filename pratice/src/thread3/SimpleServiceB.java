package thread3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:32 2019/5/25
 * @Modified By:
 */
public class SimpleServiceB extends AbstractService{

    public SimpleServiceB(CountDownLatch latch){
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {
        Thread.sleep(4000);
    }
}
